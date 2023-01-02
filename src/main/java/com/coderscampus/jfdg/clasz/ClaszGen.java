package com.coderscampus.jfdg.clasz;

import java.io.StringWriter;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.trial.GenBase;
import com.coderscampus.generator.util.Names;

public class ClaszGen extends GenBase {

    public ClaszGen(GenMeta genMeta) {
        super(genMeta);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        String secondMethod = Names.randomName();
        String argument = Names.randomName();
        String someValue = Names.randomName();
        this.context.put("argument", argument);
        this.context.put("secondMethod", secondMethod);
        this.context.put("SecondClass", this.genMeta.getName());
        this.context.put("package", this.genMeta.getPakage());
        this.context.put("someValue", someValue);
        merge(stringWriter);
        return writer;
    }

    public void write(){
        // ao nothing
    }

}
