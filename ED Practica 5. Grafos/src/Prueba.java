
public class Prueba {
    public static void main (String [] args) {
        final int numeroContactos = 10;
        Persona[] contactos = new Persona[numeroContactos];
        Seguir_AETSISI g = new Seguir_AETSISI(numeroContactos,contactos);
        Persona juan = new Persona("Juan Nadie", "111111", "0");
        Persona jose = new Persona("Jose Cuervo", "222222", "1");
        Persona eva = new Persona("Eva Adan", "333333", "2");
        Persona alicia = new Persona("Alicia Maravillas", "777777", "3");
        Persona alan = new Persona("Alan Turing", "999999", "4");
        Persona guille = new Persona("Guillermo Tell", "159267", "5");
        Persona julio = new Persona("Julio Catedrales", "123456", "6");
        Persona lucas = new Persona("Lucas Pato", "231465", "7");
        Persona paula = new Persona("Paula Vazquez", "654321", "8");
        Persona clara = new Persona("Clara Oscuro", "123654", "9");
        contactos[0] = juan;
        contactos[1] = jose;
        contactos[2] = eva;
        contactos[3] = alicia;
        contactos[4] = alan;
        contactos[5] = guille;
        contactos[6] = julio;
        contactos[7] = lucas;
        contactos[8] = paula;
        contactos[9] = clara;
        g.insertaRelacion(0, 1);
        g.insertaRelacion(0,5);
        g.insertaRelacion(5,0);
        g.insertaRelacion(1,5);
        g.insertaRelacion(1,4);
        g.insertaRelacion(4,5);
        g.insertaRelacion(5,4);
        g.insertaRelacion(0,3);
        g.insertaRelacion(3,0);
        g.insertaRelacion(6,8);
        g.insertaRelacion(8,6);
        g.insertaRelacion(2,9);
        g.insertaRelacion(2,7);
        g.insertaRelacion(9,7);
        g.insertaRelacion(7,9);

        System.out.println("Apartado 2.2.1. Numero de grupos: ");
        System.out.println();
        g.contarGrupos();

        System.out.println();
        System.out.println("Apartado 2.2.2. Mostrar seguidos por Guillermo directamente");
        g.mostrarSeguidosPorADirectamente("Guillermo Tell");

        System.out.println();
        System.out.println("Apartado 2.2.3. Mostrar seguidores directos de Juan");
        g.mostrarSeguidoresDirectoDe("Juan Nadie");

        System.out.println();   
        System.out.println("Apartado 2.2.4. Pertenecen al mismo grupo");  
        if (g.sonDelMismoGrupo(lucas, clara)){
            System.out.println( lucas.getNombre()+ " " + lucas.getDireccion() + " es del mismo grupo que " +clara.getNombre() +" " + clara.getDireccion());
        }else{
            System.out.println("No pertenecen al mismo grupo");
        }

        System.out.println();   
        System.out.println("Apartado 2.2.5. Mostrar personas mismo grupo de Clara 9");   
        g.motrarMiembrosGrupo(clara);

        System.out.println();  
        System.out.println("Apartado 2.2.6. Mostrar personas seguidas directa o indirectamente por Guillermo 5");  
        g.motrarSeguidosPor(guille);
        System.out.println();  
        System.out.println("Apartado 2.2.7. Juan 0 sigue a Alicia 3");  
        System.out.println(g.mostrarEsSeguidaPor("Eva Adan", "Clara Oscuro"));
        
        System.out.println();  
        System.out.println("Apartado 2.2.8. Seguidores de Alicia");  
        g.mostrarSeguidoresDe("Alicia Maravillas");
       
    }
}
