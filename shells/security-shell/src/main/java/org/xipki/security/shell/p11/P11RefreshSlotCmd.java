/*
 *
 * Copyright (c) 2013 - 2017 Lijun Liao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xipki.security.shell.p11;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.xipki.console.karaf.IllegalCmdParamException;
import org.xipki.security.pkcs11.P11CryptService;
import org.xipki.security.shell.SecurityCommandSupport;
import org.xipki.security.shell.completer.P11ModuleNameCompleter;

/**
 * @author Lijun Liao
 * @since 2.0.0
 */

@Command(scope = "xi", name = "refresh-p11",
        description = "refresh PKCS#11 module")
@Service
public class P11RefreshSlotCmd extends SecurityCommandSupport {

    @Option(name = "--module",
            description = "name of the PKCS#11 module.")
    @Completion(P11ModuleNameCompleter.class)
    private String moduleName = DEFAULT_P11MODULE_NAME;

    @Override
    protected Object execute0() throws Exception {
        P11CryptService p11Service = p11CryptServiceFactory.getP11CryptService(moduleName);
        if (p11Service == null) {
            throw new IllegalCmdParamException("undefined module " + moduleName);
        }
        p11Service.refresh();
        println("refreshed module " + moduleName);
        return null;
    }

}
