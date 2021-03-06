/**
 * Copyright (c) 2018, Mihai Emil Andronache
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1)Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2)Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3)Neither the name of docker-java-api nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.docker;

import java.io.IOException;
import javax.json.JsonObject;

/**
 * A docker image.
 * @author George Aristy (george.aristy@gmail.com)
 * @version $Id$
 * @see <a href="https://docs.docker.com/engine/api/v1.35/#tag/Image">Docker Images API</a>
 * @since 0.0.1
 * @todo #96:30min Finish implementing the operations that affect a single
 *  docker image (I think `tag` is the only one remaining). See the link
 *  referenced above.
 */
public interface Image {

    /**
     * Return low-level information about this image. 
     * @return JsonObject information.
     * @see <a href="https://docs.docker.com/engine/api/v1.35/#operation/ImageInspect">Inspect Image</a>
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *  the expected one (200 OK).
     */
    JsonObject inspect() throws IOException, UnexpectedResponseException;
    
    /**
     * Return parent layers of this Image.
     * @return Images parent Images.
     * @see <a href="https://docs.docker.com/engine/api/v1.35/#operation/ImageHistory">Image History</a>
     */
    Images history();

    /**
     * The parent {@link Images}.
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *  the expected one (200 OK).
     * @see <a href="https://docs.docker.com/engine/api/v1.35/#operation/ImageDelete">Remove an image</a>
     */
    void delete() throws IOException, UnexpectedResponseException;
}
