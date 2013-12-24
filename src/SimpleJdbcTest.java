import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TATARAO
 */
public class SimpleJdbcTest {
    public static void main(String args[])
    {
      DriverManagerDataSource datasource=new DriverManagerDataSource();
    
      datasource.setDriverClassName("org.gjt.mm.mysql.Driver");
      datasource.setUrl("jdbc:mysql://localhost:3306/test");
      datasource.setUsername("root");
      datasource.setPassword("root");
       
      JdbcTemplate jt=new JdbcTemplate(datasource);
      
      jt.execute("insert into jdbctemp values(900,'raja','hyd')");
      jt.execute("insert into jdbctemp values(901,'rao','vizag')");
      jt.execute("insert into jdbctemp values(902,'sanjay','pune')");
      
      int count=jt.queryForInt("select count(*) from jdbctemp");
        System.out.println("Count: "+count);
        
        jt.execute("delete from jdbctemp where sno>=901");
        
      count=jt.queryForInt("select count(*) from jdbctemp");
        System.out.println("Count : "+count);
    }
}
