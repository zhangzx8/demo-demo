package com.gome.test;

import java.io.IOException;
import java.util.Vector;

import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.UserTarget;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.PrivDES;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpDemo {

	public static void main(String[] args) throws IOException {
		// 设置管理进程的IP和端口
		Address targetAddress = GenericAddress.parse("udp:192.168.237.128/161");
		TransportMapping transport = new DefaultUdpTransportMapping();
		Snmp snmp = new Snmp(transport);
		USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(MPv3.createLocalEngineID()), 0);
		SecurityModels.getInstance().addSecurityModel(usm);
		transport.listen();
		//设置连接用户：
		snmp.getUSM().addUser(new OctetString("ray"), new UsmUser(new OctetString("ray"), AuthMD5.ID,
				new OctetString("zhangzhixiang"), PrivDES.ID, new OctetString("zhangzhixiang")));
			//设置 target
		  // CommunityTarget target = new CommunityTarget();
		  UserTarget target = new UserTarget();
		  target.setAddress(targetAddress);
		    target.setRetries(2);// 通信不成功时的重试次数
		  target.setTimeout(1500); // 超时时间
		  target.setVersion(SnmpConstants.version3);  // snmp版本
		  target.setSecurityLevel(SecurityLevel.AUTH_PRIV);
		  target.setSecurityName(new OctetString("ray"));
		  
		  //创建 PDU
		  // PDU pdu = new PDU();
		  PDU pdu = new ScopedPDU();
		  // pdu.setRequestID((new Integer32(1234)));
		  pdu.setErrorIndex(2);
		  // pdu.add(new VariableBinding(new
		  // OID(".1.3.6.1.4.1.15227.1.3.1.1.1.0"),
		  // new OctetString("cpuUsage")));
		  pdu.add(new VariableBinding(new OID(".1.3.6.1.4.1.15227.1.4.1.1.1.0")));
		  pdu.setType(PDU.GET);//数据获取方式为GET
		  
		  
		  
		  
		 // 向Agent发送PDU，并接收Response
		  ResponseEvent respEvnt = snmp.send(pdu, target);

		  if (respEvnt != null && respEvnt.getResponse() != null) {
		   Vector<VariableBinding> recVBs = (Vector<VariableBinding>) respEvnt
		     .getResponse().getVariableBindings();
		    for (int i = 0; i < recVBs.size(); i++) {
		       VariableBinding recVB = recVBs.elementAt(i);

		       System.out.println(recVB.getOid().toString()+"-"+recVB.getVariable().toString());//打印下相应节点的值，看是否正确获取
		      }
		  }
	}
}
