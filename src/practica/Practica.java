/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica;
import java.util.Scanner;
import static java.lang.Integer.parseInt;/**
 *
 * @author rodri
 */
public class Practica { 
    public static String [][] productos = new String[20][2];
    public static int idProductos = 0;
    public static Scanner entrda = new Scanner(System.in);
    public static String opcion = "";
    public static String [][] promos = new String [20][2];
    public static int idPromos = 0;
    public static String [][] compras = new String [20][2];
    public static int idCompras = 0;
    public static String [][] ventas = new String [20][3];
    public static int idVentas = 0;
    public static Float [][] cantidadt = new Float [20][1];
    public static int idCantidadt = 0;
    
    
    
    public static void main(String[] args) {
        
    String usuario = ObtenerDato("Ingrese su nombre de usuario:");
    String clave = ObtenerDato("Ingrese su contraseña:");
    
    if ("1".equals(usuario) && "1".equals(clave)){
    
        // TODO code application logic here
        while (!opcion.equals("5")) {
            
            ListaOpciones();
            Menu();
        } 
        }
    }
    public static int numven = 0;
    public static int op = 0;
    public static void ListaOpciones()
    {
        Mensaje("__________________________________________________");
        Mensaje("Bienvenido a Super-25");
        Mensaje("Puede realizar las siguientes opciones");
        Mensaje("1. Agregar Nuevo Producto");
        Mensaje("2. Agregar Codigo Promocional de descuento");
        Mensaje("3. Realizar una Venta");
        Mensaje("4. Realizar un Reporte");
        Mensaje("5. Salir");
        Mensaje("");
        opcion = ObtenerDato("Ingresar el numero de la opcion");
        
        Mensaje("__________________________________________________");
    }
    
    public static void Menu()
    {
        switch (opcion) {
            case "1" -> NuevoProducto();
            case "2" -> NuevaPromo();
            case "3" -> Venta();
            case "4" -> Reporte();
            default -> Mensaje("Saliendo del programa");
        }
    }
    
    public static void NuevoProducto()
    {
        Mensaje("-----INGRESO DE NUEVOS PRODUCTOS-----");
               // 0, 1        // 1
        if(idProductos<productos.length)
        {   boolean ciclo = false;
            while(ciclo == false){
            Mensaje("-----Ingrese los datos del producto-----");
            Mensaje(" ");
            String nombre = ObtenerDato("Ingrese el nombre del producto:");
            String precio = ObtenerDato("Ingrese el precio del producto:");
            
            if(Float.valueOf(precio) > 0){
            
            AgregarDatos(nombre, precio);
            ciclo = true;
            }else{
            Mensaje("El precio no puede ser igual a Q0,00");
            }}
        }
        else
        {
            Mensaje("Se a alcanzado el limite de estudiates");
        }
    }
    
    public static void AgregarDatos(String nombre, String precio)
    {
        if(ExisteProducto(nombre)== -1)
        {
            productos[idProductos][0] = nombre;
            productos[idProductos][1] = precio;
            idProductos++;
            Mensaje("Se ha registrado el producto con el nombre: "+nombre);
        }
        else
        {
            Mensaje("El siguiente producto ya existe: "+nombre);
        }
    }
    
    public static int ExisteProducto(String nombre)
    {
        for (int i = 0; i < productos.length; i++) {
            
            if(productos[i][0]!=null)
            {
                if(productos[i][0].equals(nombre))
                {
                    return i;
                }
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }
    
     public static float ExistePromo(String nombre)
    {
        for (int i = 0; i < promos.length; i++) {
            
            if(promos[i][0]!=null)
            {
                
                if(promos[i][0].equals(nombre))
                {
                    return Float.parseFloat(promos[i][1]);
                }
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }
    
    
    public static int contar(String cantidad) {
            int Letras = 0;
            for (int i = 0; i < cantidad.length(); i++) {
                if(Character.isLetter(cantidad.charAt(i))){
                    Letras++;
                }
            }
            return Letras;
    }
    
    public static void NuevaPromo()
    {
        Mensaje("-----INGRESE DATOS PROMOCION-----");
               // 0, 1        // 1
        if(idPromos<promos.length)
        {
            boolean ciclo = false;
            while(ciclo == false){
            Mensaje("-----Ingrese los datos del descuento-----");
            Mensaje(" ");
            
            String codigo = ObtenerDato("Ingrese el codigo de descuento:");
            String porcentaje = ObtenerDato("Ingrese el porcentaje de descuento:");
        
            if(parseInt(porcentaje)>0 && parseInt(porcentaje)<100 && contar(codigo)==4)
            {
            AgregarPromo(codigo, porcentaje);
            ciclo = true;
                System.out.println("El siguiente codigo de descuento ha sido agregado:" + codigo);
            }
            else {
                 Mensaje("Corroborre que el promocinal no exista, el porcentaje sea mayor a 0 y menor a 100 o que el codigo sean caracteres");
                    }
            } 
        }
        else
        {
            Mensaje("Se a alcanzado el limite de estudiates");
        }
    }
    
    public static void AgregarPromo(String codigo, String porcentaje)
    {
        if(ExistePromo(codigo)== -1 )
        {
            promos[idPromos][0] = codigo;
            promos[idPromos][1] = porcentaje;
            
            idPromos++;
            
        }
        else
        {
            Mensaje("No se agrego el codigo: "+codigo);
        }
    }
    
    
    
    
    public static void VerListado()
    {                       
        Mensaje("Listados de productos registrados");
        // 10
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null) {
                System.out.print(i+1+ ") Producto: " + productos[i][0]);
                System.out.print(" Precio: " + productos[i][1]);
                Mensaje(" ");
            }
        }
    }
    
    public static void VerCarrito()
    {                       
        Mensaje("Productos Comprados");
        // 10
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i][0] != null) {
                System.out.print(i+1+ ") Producto: " + ventas[i][0]);
                System.out.print(" Monto: " + ventas[i][1]);
                System.out.print(" Cantidad: " + ventas[i][2]);
                Mensaje(" ");
            }
        }
    }
    
    
    
    
     public static void Venta(){
         ventas = new String [20][3];
         numven = 0;
    Mensaje("AREA DE VENTAS");
    String fecha = ObtenerDato("Ingrese la fecha de hoy #/#/#");
    String comprador = ObtenerDato("Ingrese el nombre del cliente:");
    String NIT = ObtenerDato("Ingrese su numero de nit o de lo contrario ingrese C/F");
    boolean repetir = false;
    Float Total = 0.0f;
    while(repetir == false)
            {
                VerListado();
    String producto = ObtenerDato("Ingrese la opcion del producto que desea comprar: ");
    String cantidad = ObtenerDato("Ingrese la cantidad a comprar: ");
    op = parseInt(producto)-1;
    ventas [numven][0]= productos[op][0];
    ventas [numven][2] = cantidad;
    /**cantidadt [op] += Float.valueOf(cantidad);**/
    Total = Float.valueOf(cantidad)*Float.valueOf(productos[op][1]);
    ventas[numven][1] = String.valueOf(Total);
    numven ++;
    Mensaje("Desea hacer otra comprar");
    Mensaje("1. Si");
    String continuar = ObtenerDato ("2. No");
    if("2".equals(continuar)){
      System.out.print("FACTURA");
      
      repetir = true;
       
       
    }
    Mensaje(" ");
       
            }
    Mensaje("Super-25");
    Total = 0.0f;
    for (int i = 0; i < ventas.length; i++) {
            if (ventas[i][0] != null) {
                Total += Float.valueOf(ventas[i][1]);
            }
    }
    VerCarrito();
         System.out.println("El subtotal de su compra es de: Q" +Total);
    Mensaje("Posee algun codigo de descuento");
    Mensaje("1. Si");
    String val = ObtenerDato ("2. No");
    if ( "1".equals(val)){
    String des = ObtenerDato ("Ingrese su codigo de descuento");
    float fun = ExistePromo(des);
    
    if(fun >= 0){
        float Totalf = Total - Total*(fun/100);
        Mensaje("Super-25");
        Mensaje("Cajero: Rodrigo Castro");
         Mensaje(" ");
        System.out.print("Cliente: " + comprador);
        Mensaje(" ");
        System.out.print("NIT: " + NIT);
         Mensaje(" ");
         System.out.print("Fecha: " + fecha);
         Mensaje(" ");
         VerCarrito();  
        System.out.print("Subtotal: " + Total);
         Mensaje(" ");
        System.out.print("Descuento: " + fun + "%");
         Mensaje(" ");
        System.out.print("TOTAL: " + Totalf);
         Mensaje(" ");
        }
    else {
    
    }
    }
     }
   
     public static void Reporte(){
     Mensaje("AREA ReEPORTE");
     
     }
    
    public static String ObtenerDato(String msj)
    {
        Mensaje(msj);
        return entrda.nextLine();
    }
    
    public static void Mensaje(String msj)
    {
        System.out.println(msj);
    }
    
}
