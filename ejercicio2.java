public class ejercicio2
{
    public boolean puedoGenerar(String [] a,String x){
        String [] aux = new String[x.length()];
        aux = llenar(aux,x,0);
        boolean res = false;
        return puedoGenerar(a,aux,0,0);
    }
    
    private boolean puedoGenerar(String [] a,String [] aux,int i,int j){
        boolean res = false;
        if(i < a.length){
            if(a[i].length() < 2){
                if(a[i].equals(aux[j])){
                    if(aux[j].equals(aux[aux.length-1])){
                        res = true;
                    }else{
                        res = puedoGenerar(a,aux,i+1,j+1);
                    }
                }else{
                    res = puedoGenerar(a,aux,i+1,j);
                }
            }else{
                String[] subCad = new String[a[i].length()];
                subCad = llenar(subCad,a[i],0);
                int z = 0;
                boolean bandera=SubArr(subCad,aux,z,j);
                if(bandera){
                    j = j +subCad.length;
                }
                if(j == aux.length){
                    res = true;
                }else{
                    res = puedoGenerar(a,aux,i+1,j);
                }
            }    
        }
        return res;
    }
    
    private boolean SubArr(String [] subCad, String [] aux, int z, int j){
        boolean res = false;
        if(z < subCad.length){
            if(subCad[z].equals(aux[j])){
                if(subCad[z].equals(subCad[subCad.length-1])){
                    res = true;
                }else{
                    res = SubArr(subCad,aux,z+1,j+1);
                }
            }else{
                res = false;
            }
        }
        return res;
    }
    
    private String[] llenar(String [] aux, String x, int n){
        if(n < aux.length){
            aux[n] = Character.toString(x.charAt(n));
            llenar(aux,x,n+1);
        }
        return aux;
    }
}
