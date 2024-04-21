public class ejercicio1{
    public boolean puedoSalir(int n, String[] maze){
        boolean res;
        char[][] laberinto = new char[n][n];
        laberinto = generarLab(n,maze,0,0,laberinto);
        
        int xE = BuscarX(maze,'E',0,0);
        int yE = BuscarY(maze,'E',0,0);
        int xS = BuscarX(maze,'S',0,0);
        int yS = BuscarY(maze,'S',0,0);
        
        return puedoSalir(laberinto,xE,yE,xS,yS,n);
    }
    
    private boolean puedoSalir(char[][] lab,int x,int y,int xS,int yS,int n){
        boolean encontro = false;
        if(valida(x,y,n)){
            if(lab[x][y] == '*' || lab[x][y] == 'S'|| lab[x][y] == 'E'){
                if(x == xS && y == yS){
                    encontro = true;
                }else{ 
                    lab[x][y] = '.';
                    encontro = puedoSalir(lab,x-1,y,xS,yS,n);
                    if(!encontro){
                        encontro = puedoSalir(lab,x,y+1,xS,yS,n);
                        if(!encontro){
                            encontro = puedoSalir(lab,x+1,y,xS,yS,n);
                            if(!encontro){
                                encontro = puedoSalir(lab,x,y-1,xS,yS,n);
                            }
                        }
                    }
                    lab[x][y] = '*';
                }
            }else{
                encontro = false;
            }
        }else{
            encontro = false;
        }
        return encontro;
    }
    
    private boolean valida(int x,int y,int n){
        boolean val;
        if(x < n && y < n && x>=0 && y>= 0){
            val = true;
        }else{
            val = false;
        }
        return val;
    }
        
    private int BuscarY(String[] laberinto,char a,int i ,int j){
        int res =0;
        if(i<laberinto.length){
            if(j<laberinto.length){
                if(laberinto[i].charAt(j)==a){
                    res = j;
                }else{
                    res = BuscarY(laberinto,a,i,j+1);
                }
            }else{
                j=0;
                res = BuscarY(laberinto,a,i+1,j);
            } 
        }
        return res;
    }
    
    private int BuscarX(String[] laberinto,char a,int i ,int j){
        int res=0;
        if(i<laberinto.length){
            if(j<laberinto.length){
                if(laberinto[i].charAt(j)==a){
                    res = i;
                }else{
                    res = BuscarX(laberinto,a,i,j+1);
                }
            }else{
                j=0;
                res = BuscarX(laberinto,a,i+1,j);
            }   
        }
        return res;
    }

    private char[][] generarLab(int n,String[] maze,int i,int j,char[][] laberinto){
        if(i<n){
            if(j<n){
                laberinto[i][j] = maze[i].charAt(j);
                laberinto = generarLab(n,maze,i,j+1,laberinto);
            }else{
                j=0;
                laberinto= generarLab(n,maze,i+1,j,laberinto);
            }
        }
        return laberinto;
    }
}