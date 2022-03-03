package org.apache.skywalking.apm.testcase.tomcatserver;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class Application {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector con = new Connector();
        con.setPort(18080);
        tomcat.getService().addConnector(con);
        Context ctx = tomcat.addContext("/tomcatserver-10.x-scenario", null);
        Tomcat.addServlet(ctx, "caseServlet", "org.apache.skywalking.apm.testcase.tomcatserver.servlet.CaseServlet");
        ctx.addServletMappingDecoded("/case/tomcat-10.x-scenario", "caseServlet");
        tomcat.start();
    }
}
