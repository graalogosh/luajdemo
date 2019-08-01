package com.github.graalogosh.luajdemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Log4j2
public class LuajdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LuajdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        final String statement = "print (variable); return variable;";
        final String statement = "for i=1, 4 do print(variable[i]) end; return variable[1];";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("lua");
        CompiledScript script = ((Compilable) engine).compile(statement);

        SimpleBindings sb = new SimpleBindings();
        sb.put("variable", new String[]{"first", "second", "third"});

        log.info("Result of LUA call: {}", script.eval(sb));



//        List<ScriptEngineFactory> factories = manager.getEngineFactories();
//
//        for (ScriptEngineFactory factory : factories) {
//
//           log.info("ScriptEngineFactory Info");
//
//            String engName = factory.getEngineName();
//            String engVersion = factory.getEngineVersion();
//            String langName = factory.getLanguageName();
//            String langVersion = factory.getLanguageVersion();
//
//            log.info("\tScript Engine: {} ({})", engName, engVersion);
//
//            List<String> engNames = factory.getNames();
//            for(String name : engNames) {
//                log.info("\tEngine Alias: {}", name);
//            }
//
//            log.info("\tLanguage: {} ({})", langName, langVersion);
//
//        }
    }
}
