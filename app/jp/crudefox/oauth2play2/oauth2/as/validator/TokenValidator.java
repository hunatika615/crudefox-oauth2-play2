/**
 *       Copyright 2010 Newcastle University
 *
 *          http://research.ncl.ac.uk/smart/
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.crudefox.oauth2play2.oauth2.as.validator;

//import play.api.mvc.Request;

import jp.crudefox.oauth2play2.oauth2.bridge.BridgeRequest;
import jp.crudefox.oauth2play2.oauth2.common.OAuth;
import jp.crudefox.oauth2play2.oauth2.common.error.OAuthError;
import jp.crudefox.oauth2play2.oauth2.common.exception.OAuthProblemException;
import jp.crudefox.oauth2play2.oauth2.common.validators.AbstractValidator;


/**
 *
 *
 *
 */
public class TokenValidator extends AbstractValidator<BridgeRequest> {

    public TokenValidator() {
        requiredParams.add(OAuth.OAUTH_RESPONSE_TYPE);
        requiredParams.add(OAuth.OAUTH_CLIENT_ID);
        requiredParams.add(OAuth.OAUTH_REDIRECT_URI);
    }

    @Override
    public void validateMethod(BridgeRequest request) throws OAuthProblemException {
        String method = request.method();
        if (!method.equals(OAuth.HttpMethod.GET) && !method.equals(OAuth.HttpMethod.POST)) {
            throw OAuthProblemException.error(OAuthError.CodeResponse.INVALID_REQUEST)
                .description("Method not correct.");
        }
    }

    @Override
    public void validateContentType(BridgeRequest request) throws OAuthProblemException {
    }
}
