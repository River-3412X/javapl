import java.sql.*;

public class Base {
    Connection myCon;
    Statement myStatement;
    PreparedStatement myPrepareStatement;
    ResultSet myResult;
    public  Base(){
        try{
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingresos_022024","root","");
        }
        catch ( Exception ex){
            ex.printStackTrace();
        }
    }
    public ResultSet consultar(String sql){
        try{
            this.myStatement = myCon.createStatement();
            this.myResult=this.myStatement.executeQuery(sql);
        }
        catch (Exception x){
            x.printStackTrace();
        }
        return this.myResult;
    }
    public ResultSet consultar(String sql,String parametros[]){
        try{
            this.myPrepareStatement = myCon.prepareStatement(sql);
            if( parametros.length>0 ){
                int contador = 1;
                for (int i = 0; i < parametros.length; i++) {
                    this.myPrepareStatement.setString(contador,parametros[i]);
                    contador++;
                }
            }
            this.myResult=this.myPrepareStatement.executeQuery();
        }
        catch (Exception x){
            x.printStackTrace();
        }
        return this.myResult;
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
