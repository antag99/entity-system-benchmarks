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
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

import com.badlogic.ashley.core.Engine;
import com.github.esfbench.JmhSettings;
import com.github.esfbench.ashley.system.CompSystemA;
import com.github.esfbench.ashley.system.CompSystemB;
import com.github.esfbench.ashley.system.CompSystemC;
import com.github.esfbench.ashley.system.CompSystemD;
import com.github.esfbench.ashley.system.EntityManglerSystem;

public class InsertRemoveBenchmark extends JmhSettings {
	
	private Engine engine;

	// restricting due to memory bug.
	// see: https://github.com/libgdx/ashley/issues/129
//	@Param({"1024", "4096"})
//	@Param({"1024", "4096"})
//	@Param("16384")
//	public int entityCount;
	
	@Setup
	public void init() throws Exception {
		engine = new Engine();
		engine.addSystem(new EntityManglerSystem(SEED, entityCount, 20));
		engine.addSystem(new CompSystemA());
		engine.addSystem(new CompSystemB());
		engine.addSystem(new CompSystemC());
		engine.addSystem(new CompSystemD());
	}		
	
	@Benchmark
	public void insert_remove() {
		engine.update(0);;
	}
	
	public static void main(String[] args) throws Exception {
//		new Runner(
//			new OptionsBuilder()
////				.include(".*insert_remove.*")
//				.include(".*insert.*")
//				.param("entityCount", "1024", "4096")
////				.param("entityCount", "1024")
//				.build())
//		.run();
		
		System.out.println("hello there");
//		new Scanner(System.in).nextLine();
//		
		InsertRemoveBenchmark irb = new InsertRemoveBenchmark();
		irb.entityCount = 128;
		irb.init();
		for (int i = 0, s = 10000; s > i; i++) {
			irb.insert_remove();
		}
	}
}
