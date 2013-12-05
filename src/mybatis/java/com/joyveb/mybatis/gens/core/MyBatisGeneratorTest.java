package com.joyveb.mybatis.gens.core;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorTest {

    public static void testGenerateMyBatis3() throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MyBatisGeneratorTest.class.getResourceAsStream("generatorConfigTest.xml"));
            
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
        	e.printStackTrace();
            throw e;
        }
    }
    public static void main(String[] args) throws Exception {
    	testGenerateMyBatis3();
	}
}
