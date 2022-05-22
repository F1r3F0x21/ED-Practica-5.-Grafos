
public class Seguir_AETSISI {
    //NOMBRE  Y GRUPO DEL ALUMNO
    private GrafoMA mired;
    private Persona[] contactos;


    public Seguir_AETSISI(int n, Persona[] contactos) { //construye una matriz de nxn sin aristas
        mired= new GrafoMA(n,true);
        this.contactos = contactos;
    }

    public int getNumPersonas() {
        return mired.getNumVertices();
    }


    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------
// método que inserta una relación de seguir_a directa (una arista en el grafo)
    public void insertaRelacion(int o, int d) {
            mired.insertarArista(o,d);
    }
    // método que elimina una relación de seguir_a directa (una arista en el grafo)
    public void eliminaRelacion(int o, int d) {
        mired.eliminarArista(o,d);
    }
    // método que indica si existe una relación de seguir_a directa (una arista en el grafo)
    public boolean existeRelacion(int o, int d) {
        return mired.existeArista(o,d);
    }

    //Metodo que compara dos cadenas que representan dos nombres ignorando mayusculas y minusculas
    private boolean nombresIguales(String cad1, String cad2){
        return (cad1.equalsIgnoreCase(cad2));
    }


    // encuentra la posición asociado a un nombre de persona en la tabla de contactos que
    // ademas se corresponde con el vertice que le representa en el grafo

    public int devuelvePosNombre(String nombre){
        int i=0;
        boolean encontrado=false;
        while (i<contactos.length && !encontrado){
            encontrado= nombresIguales(nombre,contactos[i].getNombre());
            if (!encontrado) i++;
        }
       // if (!mired.verticeEnRango(i)) i=-1;//si ha salido por i= contactos.length no esta el nombre en la tabla
        if (!encontrado) i=-1;
        return i;
    }

    // Imprime la Matriz del relaciones( Matriz de adyacencia del grafo) por consola
    public void imprimirRelaciones() {
        System.out.println("Contenido de la matriz: ");
        System.out.print("  ");
        for (int i = 0; i < mired.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+i +" ");
             else System.out.print(i+" " );
        }
        System.out.println();
        for (int i = 0; i < mired.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+i );
            else System.out.print(i );
        for (int j = 0; j < mired.getNumVertices(); j++) {
                if (mired.existeArista(i,j)) System.out.print(" S ");
                else System.out.print(" N ");
            }
            System.out.println();
        }
    }

    //Imprime la información de la red y la matriz de Relaciones por consola
    public void mostrarRed() {
        System.out.println("Existen " + mired.getNumVertices() + " contactos: \n");
        for (int i = 0; i < mired.getNumVertices(); i++)
            System.out.println(i + ": " + contactos[i].getNombre());
        imprimirRelaciones();
        System.out.println();
    }

// ------------------------------------

    // MÉTODOS A COMPLETAR

    // ------------------------------------


public void mostrar(){
        mired.mostrar();
}


    // Apartado 2.2.1 Primer método

    public int contarGrupos() {
        int resul = 0;
        //Completar
        boolean[] visitados = new boolean[mired.getNumVertices()];
        for (int i = 0; i < mired.getNumVertices(); i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < mired.getNumVertices(); i++) {
            if (!visitados[i]) {
                mired.recorridoEnProfundidadCadena(i, visitados);
                resul++;
            }
        }
        System.out.println("Hay " + resul + " grupos.");
        return resul;
    }






    // Apartado 2.2.2 Segundo método
    public void mostrarSeguidosPorADirectamente(String nombre) {
        int i, j = 0;
        int num = devuelvePosNombre(nombre);
        System.out.println("Seguidos por "+ nombre + "("+ num + ")");
        if (num == -1){
            System.out.println("El nombre no existe");
        }else{
            for (i = 0; i< getNumPersonas(); i++){
                if (existeRelacion(num,i)){
                    System.out.println(j + ": " + contactos[i].getNombre() );
                    j++;
                }
        }
        }
            
    }
        

    // Apartado 2.2.3 Tercer método
    public void mostrarSeguidoresDirectoDe(String nombre) {
        int i;
        int num = devuelvePosNombre(nombre);
        System.out.println("Seguidores de "+ nombre + "("+ num + ")");
        if (num == -1){
            System.out.println("El nombre no existe");
        }else{
            for (i = 0; i< getNumPersonas(); i++){
                if (existeRelacion(i,num)){
                    System.out.println(i + ": " + contactos[i].getNombre() );
                }
        }
        }
    }
    // Apartado 2.2.4 Cuarto método


  public boolean sonDelMismoGrupo(Persona p, Persona p1){
    int i = 0;
    int n = devuelvePosNombre(p.getNombre());
    int m = devuelvePosNombre(p1.getNombre());
    boolean[] visitados = new boolean[mired.getNumVertices()];
    boolean resul = false;

        for (i = 0; i < getNumPersonas() ; i++){
            visitados[i] = false;
        }

        for (int j = 0; j < getNumPersonas(); j++){
            if (!visitados[j]){
                mired.recorridoEnProfundidadCadena(j, visitados);
                if (visitados[n] && visitados[m]){
                    resul = true;
                }else{
                    for (int k = 0; k < getNumPersonas(); k++){
                        visitados[k] = false;
                    }
                }
            }
        }
        return resul;
  }
  

    // Apartado 2.2.5 Quinto método
    public void motrarMiembrosGrupo(Persona p){
        int n = devuelvePosNombre(p.getNombre());
        boolean[] visitados = new boolean[mired.getNumVertices()];
        for (int i = 0; i < getNumPersonas(); i++){
            visitados[i] = false;
        }
        
        for (int j = 0; j < getNumPersonas(); j++){
            if (!visitados[j]){
                mired.recorridoEnProfundidadCadena(j, visitados);
                if (visitados[n]){
                    for (int k = 0; k< getNumPersonas(); k++){
                        if (visitados[k] && k != n){
                            System.out.println(k + ": " +contactos[k].getNombre());
                        }
                    }
                    j = getNumPersonas() -1;
                }else{
                    for (int k = 0; k < getNumPersonas(); k++){
                        visitados[k] = false;
                    }
                }
            }
        }
    }

    // Apartado 2.2.6 sexto método
    public void motrarSeguidosPor(Persona p){
        int n = devuelvePosNombre(p.getNombre());
        boolean resul = false;
        boolean[] visitados = new boolean[mired.getNumVertices()];
        mired.recorrerAmplitudVertice(n, visitados, resul);
        for (int i = 0; i <getNumPersonas(); i++){
            if (visitados[i] && i != n){
                System.out.println(i + ": " +contactos[i].getNombre());
            }
        }
    }



    // Apartado 2.2.7 séptimo método

    public boolean mostrarEsSeguidaPor(String nombre1, String nombre2){
        boolean resul = false;
        int n = devuelvePosNombre(nombre1);
        int m = devuelvePosNombre(nombre2); 
        boolean[] visitados = new boolean[mired.getNumVertices()];
        mired.recorrerAmplitudVertice(n, visitados, resul);
        if (visitados[m]){
            resul = true;
        }
    
        return resul;
    }


    // Apartado 2.2.8 octavo método (opcional)
   public void mostrarSeguidoresDe(String nombre1){
    boolean resul = false;
    int n = devuelvePosNombre(nombre1);
    int rep = 0;
    boolean[] visitados = new boolean[mired.getNumVertices()];
    System.out.println("Seguidores de " + contactos[n].getNombre()+ "(" + n + ")");
        for (int j = 0; j < getNumPersonas(); j++){
            mired.recorrerAmplitudVertice(j, visitados, resul);
            if (visitados[n] && visitados[j]){
                if (j != n){
                    System.out.println(j + ": " + contactos[j].getNombre());
                    rep++;
                }
                for (int i = 0; i < getNumPersonas(); i++){
                    visitados[i] = false;
                }
            }
        }
        if (rep == 0){
            System.out.println("No existe camino para " + n);
        }
   }
   


}




