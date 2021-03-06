/*******************************************************************************
 * Copyright (c) 2011 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package server;

import java.io.IOException;
import java.io.OutputStream;

/**
 * A process OutputStream that writes output the stream to the play cache.
 * 
 * @author adaml
 *
 */
public class ProcOutputStream extends OutputStream {

	WriteEventListener procExecListener;
	@Override
	public void write(int b) throws IOException {
		procExecListener.writeEvent(b);

	}
	
	public void setProcEventListener(WriteEventListener listener) {
		this.procExecListener = listener;
	}

}
