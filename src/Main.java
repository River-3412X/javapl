
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
       Main obj = new Main();


       /*
       String sql = "INSERT INTO usuarios (id,nombre,usuario,password,firma,nivel,estado,rfc) values(?,?,?,?,?,?,?,?)";
       String parametros[]={
               "19",
               "River",
               "riverUSer",
               "passwordRiver",
               "firma",
               "1",
               "Activo",
               "rfc"
       };
       obj.insertar(sql,parametros);

        //aqui se actualiza
        String sql = "UPDATE usuarios set nombre = ? where id=?";
        String parametros[]={
                "River Corona Romero",
                "19"
        };
        obj.actualizar(sql,parametros);

        String sql = "DELETE from usuarios  where id = ? ";
        String parametros[]={
                "19"
        };
        obj.eliminar(sql,parametros);


        String sql = "SELECT * FROM usuarios";
        String param[] = {"99999"};
        obj.consultar(sql);
        */
        Base conexion = new Base();
        String sql ="Select *from usuarios where id =?";
        String parametros[]={"99999"};
        ResultSet resultado =null;

        resultado = conexion.consultar(sql,parametros);
        while ( resultado.next() ){
            System.out.println(resultado.getString("nombre")+"  "+ resultado.getString("estado") );
        }
    }

    public void consultar(String sql){
        Connection myCon = null;
        Statement myStatatment = null;
        ResultSet myResult = null;

        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");

            myStatatment = myCon.createStatement();
            myResult=myStatatment.executeQuery(sql);

            while( myResult.next() ){
                System.out.println(myResult.getString("nombre"));
            }

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
    public void consultar(String sql,String parametros[]){
        Connection myCon = null;
        PreparedStatement myPrepareStatement = null;
        ResultSet myResult = null;

        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");

            myPrepareStatement = myCon.prepareStatement(sql);
            if( parametros.length>0 ){
                int contador = 1;
                for (int i = 0; i < parametros.length; i++) {
                    myPrepareStatement.setString(contador,parametros[i]);
                    contador++;
                }
            }
            myResult=myPrepareStatement.executeQuery();

            while( myResult.next() ){
                System.out.println(myResult.getString("nombre"));
            }

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }

    public void insertar(String sql, String parametros[]){
        Connection myCon = null;
        PreparedStatement myPreparedStatement = null;
        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");
            myPreparedStatement=myCon.prepareStatement(sql);
            if(parametros.length>0){
                int contador = 1;
                for (int i = 0; i <parametros.length ; i++) {
                    myPreparedStatement.setString( contador,parametros[i] );
                    contador++;
                }
            }
            int rowsAffected = myPreparedStatement.executeUpdate();
            if( rowsAffected  > 0 ){
                System.out.println("se crearon "+rowsAffected+" usuarios");
            }
        }
        catch (Exception x){
            x.printStackTrace();
        }
    }

    public void actualizar(String sql,String parametros[]){
        Connection myCon = null;
        PreparedStatement myPrepareStatement = null;

        try{
            String nombre ="Jaimicko '  e2 2e ";
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");

            myPrepareStatement = myCon.prepareStatement(sql);
            if( parametros.length > 0 ){

                int contador =1;
                for (int i = 0; i < parametros.length ; i++) {
                    myPrepareStatement.setString(contador,parametros[i]);
                    contador++;
                }
            }

            int rowsAffected=myPrepareStatement.executeUpdate();
            if( rowsAffected >0 ){
                System.out.println("se actualizaron "+ rowsAffected+" registros ");
            }

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }

    public void eliminar(String sql, String parametros[]){
        Connection myCon = null;
        PreparedStatement myPrepareStatement = null;


        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");
            myPrepareStatement = myCon.prepareStatement(sql);

            if( parametros.length > 0 ){
                System.out.println(parametros.length);
                int contador =1;
                for (int i = 0; i < parametros.length ; i++) {
                    myPrepareStatement.setString(contador,parametros[i]);
                    contador++;
                }
            }

            int rowsAffected=myPrepareStatement.executeUpdate();
            if( rowsAffected >0 ){
                System.out.println("se eliminaron "+ rowsAffected+" registros ");
            }
        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
    public void eliminar_sin_escapar(String sql, String parametros[]){
        Connection myCon = null;
        Statement myStatement = null;
        ResultSet myResult = null;

        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");
            myStatement = myCon.createStatement();


            int rowsAffected=myStatement.executeUpdate(sql);
            if( rowsAffected >0 ){
                System.out.println("se eliminaron "+ rowsAffected+" registros ");
            }
        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
}