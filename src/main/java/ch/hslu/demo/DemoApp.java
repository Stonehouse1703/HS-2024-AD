/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
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
package ch.hslu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.demo.Point}-Klasse.
 */
public final class DemoApp {

    public static void main(String[] args) {
        System.out.println(fatrorialrec(90000));
    }

    public static long fatrorialrec(final long n) {
        if ((n == 0) || (n == 1)) {
            return  1;
        } else {
            return (n * fatrorialrec(n - 1));
        }
    }
}


