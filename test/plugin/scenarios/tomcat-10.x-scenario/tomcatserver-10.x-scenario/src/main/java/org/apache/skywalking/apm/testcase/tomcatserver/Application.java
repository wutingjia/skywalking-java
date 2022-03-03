/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
