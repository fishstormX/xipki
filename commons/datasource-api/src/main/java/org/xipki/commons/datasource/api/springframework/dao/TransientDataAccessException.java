// #THIRDPARTY# Spring Framework

/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xipki.commons.datasource.api.springframework.dao;

/**
 *
 * Root of the hierarchy of data access exceptions that are considered transient -
 * where a previously failed operation might be able to succeed when the operation
 * is retried without any intervention by application-level functionality.
 *
 * @author Thomas Risberg
 * @see java.sql.SQLTransientException
 */
@SuppressWarnings("serial")
public abstract class TransientDataAccessException extends DataAccessException {

    /**
     * Constructor for TransientDataAccessException.
     * @param msg the detail message
     */
    public TransientDataAccessException(
            final String msg) {
        super(msg);
    }

    /**
     * Constructor for TransientDataAccessException.
     * @param msg the detail message
     * @param cause the root cause (usually from using a underlying data access API such as JDBC)
     */
    public TransientDataAccessException(
            final String msg,
            final Throwable cause) {
        super(msg, cause);
    }

}
