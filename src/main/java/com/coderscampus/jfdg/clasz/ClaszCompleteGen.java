package com.coderscampus.jfdg.clasz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.trial.GenBase;

public class ClaszCompleteGen extends GenBase {

    public ClaszCompleteGen(GenMeta genMeta) {
        super(genMeta);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        this.context.put("name", new String("Velocity"));
        this.context.put("city", loremIpsum.getCity());
        this.context.put("ClassName", this.genMeta.getName());
        this.context.put("package", this.genMeta.getPakage());
        merge(stringWriter);
        write();
        return writer;
    }

    public void write(){
        System.out.println(genMeta.getWritePath());

        System.out.println(writer.toString());
        Path path = Paths.get(genMeta.getWritePath());
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(genMeta.getWritePath())) {
            fileWriter.write(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
