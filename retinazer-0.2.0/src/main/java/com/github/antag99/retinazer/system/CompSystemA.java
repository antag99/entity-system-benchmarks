package com.github.antag99.retinazer.system;

import org.openjdk.jmh.infra.Blackhole;

import com.github.antag99.retinazer.EntityProcessorSystem;
import com.github.antag99.retinazer.Family;
import com.github.antag99.retinazer.SkipWire;
import com.github.antag99.retinazer.component.Comp1;
import com.github.antag99.retinazer.component.Comp4;
import com.github.antag99.retinazer.component.Comp5;

public class CompSystemA extends EntityProcessorSystem {
    @SkipWire
    Blackhole voidness = new Blackhole();

    @SuppressWarnings("unchecked")
    public CompSystemA() {
        super(Family.with(Comp1.class, Comp4.class, Comp5.class));
    }

    @Override
    protected void process(int e) {
        voidness.consume(e);
    }
}
