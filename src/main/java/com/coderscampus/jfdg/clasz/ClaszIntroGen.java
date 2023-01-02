package com.coderscampus.jfdg.clasz;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.trial.GenBase;

import java.io.StringWriter;

public class ClaszIntroGen extends GenBase {

    public ClaszIntroGen(GenMeta genMeta) {
        super(genMeta);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        this.context.put("name", new String("Velocity"));
        this.context.put("city", loremIpsum.getCity());
        this.context.put("ClassName", this.genMeta.getName());
        this.context.put("package", this.genMeta.getPakage());
        merge(null);
        write();
        return writer;
    }

    public void write(){
        // do nothing
    }

}
