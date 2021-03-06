/*
 * Copyright (c) 2013 GigaSpaces Technologies Ltd. All rights reserved
 * <p/>
 * The software source code is proprietary and confidential information of GigaSpaces.
 * You may use the software source code solely under the terms and limitations of
 * the license agreement granted to you by GigaSpaces.
 */

package beans.cloudify;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: guym
 * Date: 4/24/13
 * Time: 12:40 PM
 */
public class CloudifyRestResult {
    public Status status;
    public List<String> errorArgs = new LinkedList<String>(  );
    public String error;

    public static enum Status{
        success, error
    }

    public boolean isSuccess(){
        return status == Status.success;
    }

    public static class ListServices extends CloudifyRestResult{
        public List<String> response;
    }

    public static class TestRest extends CloudifyRestResult{
        // nothing, empty body
    }

//    {"Cloud Public IP":"15.185.182.232"}
    public static class GetPublicIpResult{
        @JsonProperty(value = "Cloud Public IP")
        public String cloudPublicIp;
    }

    public static class ListApplications extends CloudifyRestResult{
        public Map<String, String> response;
    }
}
