/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.github.esfbench.ashley;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import com.badlogic.ashley.core.Engine;
import com.github.esfbench.JmhSettings;
import com.github.esfbench.ashley.component.PlainPosition;
import com.github.esfbench.ashley.component.PlainStructComponentA;
import com.github.esfbench.ashley.system.BaselinePositionSystem;
import com.github.esfbench.ashley.system.BaselinePositionSystem2;
import com.github.esfbench.ashley.system.BaselinePositionSystem3;
import com.github.esfbench.ashley.system.EntityDeleterSystem;

public class BaselineBenchmark extends JmhSettings {
	
	private Engine engine;
	
	@Setup
	public void init() {
		engine = new Engine();
		engine.addSystem(new EntityDeleterSystem(SEED, entityCount, PlainPosition.class, PlainStructComponentA.class));
		engine.addSystem(new BaselinePositionSystem());
		engine.addSystem(new BaselinePositionSystem2());
		engine.addSystem(new BaselinePositionSystem3());
	}		
	
	@Benchmark
	public void baseline() {
		engine.update(0);
	}
}