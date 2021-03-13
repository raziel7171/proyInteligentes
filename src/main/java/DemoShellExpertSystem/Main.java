/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoShellExpertSystem;

import DemoShellExpertSystem.base.rule.Rule;
import DemoShellExpertSystem.base.fact.IntegerFact;
import DemoShellExpertSystem.base.fact.IFact;
import DemoShellExpertSystem.base.fact.BooleanFact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prog
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerFact fact1 = new IntegerFact("orden", 3, "(¿cuál es el orden?)) ", 0);
        BooleanFact fact2 = new BooleanFact("triangulo", true, null, 0);
        Rule rule = null;
        
        List<IFact> premises = new ArrayList<>();
        premises.add(fact1);
        
        rule = new Rule("R1", premises, fact2);
        
        
        System.out.println(fact1);
        System.out.println(fact2);
        
        System.out.println(rule);
        
    }
    
}
