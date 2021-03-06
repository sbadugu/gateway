/**
 * Copyright 2007-2016, Kaazing Corporation. All rights reserved.
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
package org.kaazing.mina.util;

import org.apache.mina.core.session.IoSession;

/**
 * Monitors uncaught exceptions.  {@link #exceptionCaught(Throwable)} is
 * invoked when there are any uncaught exceptions.
 * <p>
 * You can monitor any uncaught exceptions by setting {@link ExceptionMonitor}
 * by calling {@link #setInstance(ExceptionMonitor)}.  The default
 * monitor logs all caught exceptions in <tt>WARN</tt> level using
 * SLF4J.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 *
 * @see DefaultExceptionMonitor
 */
public abstract class ExceptionMonitor {
    private static ExceptionMonitor instance = new DefaultExceptionMonitor();

    /**
     * Returns the current exception monitor.
     */
    public static ExceptionMonitor getInstance() {
        return instance;
    }

    /**
     * Sets the uncaught exception monitor.  If <code>null</code> is specified,
     * the default monitor will be set.
     *
     * @param monitor A new instance of {@link DefaultExceptionMonitor} is set
     *                if <tt>null</tt> is specified.
     */
    public static void setInstance(ExceptionMonitor monitor) {
        if (monitor == null) {
            monitor = new DefaultExceptionMonitor();
        }
        instance = monitor;
    }

    /**
     * Invoked when there are any uncaught exceptions.
     */
    public abstract void exceptionCaught(Throwable cause, IoSession s);
}
