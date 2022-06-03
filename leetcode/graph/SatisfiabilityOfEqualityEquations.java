package leetcode.graph;

public class SatisfiabilityOfEqualityEquations {


    public boolean equationsPossible(String[] equations) {
        var dsu = new DisjointSet(26);
        for(String eq : equations){
            int var1 = getAscii(eq.charAt(0)), var2 = getAscii(eq.charAt(3));
            if(eq.startsWith("==", 1))
                dsu.union(var1, var2);
        }
        for(String eq:equations){
            int var1 = getAscii(eq.charAt(0)), var2 = getAscii(eq.charAt(3));
            if(eq.startsWith("!=", 1) && (dsu.find(var1) == dsu.find(var2))) return false;
        }
        return true;
    }

    private int getAscii(char c){
        return c -97;
    }
}
