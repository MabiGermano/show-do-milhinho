/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.game.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaob
 */
public class Manipulator {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
	FileInputStream file = new FileInputStream(getPropPath());
	props.load(file);
	return props;
    }
    
    private static String getPropPath(){
        return Manipulator.class.getClassLoader().getResource("application.properties").getFile();
    }
}
