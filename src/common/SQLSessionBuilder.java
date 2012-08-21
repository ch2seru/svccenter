package common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**	작성자 : 방영호
 * 	일시 : 2012년 2월 3일 금요일
 * 	내용 : 이 클래스는 MyBatis의 SqlSession을 좀더 쉽게 얻어올 수 있도록 구현한 클래스이다.
 * 		  기본생성자로 객체를 생성할 경우 Default 로 /model/SqlMapConfig.xml 으로 
 * 		 XML 파일을 찾을 것이다. 만약 다른 경로의 XML 설정파일을 읽어들이고 싶다면
 * 		  인자생성자의 인자값으로 해당 XML 파일의 Path 및 File name 을 지정해주거나
 * 		 setResource() 메소드를 사용하여 XML 파일의 Path 및 File name 을 설정하면 된다.
 * 
 * 		 주의 : 이 클래스를 사용하여 SqlSession을 얻어온 경우 반드시 close() 메소드를
 * 			      호출하여 DB Connection 에 대한 자원을 반납해야 한다.
 * 
 * 			     그렇지 않을 경우 Memory Overflow 가 발생할 수 있다.
 * */
public class SQLSessionBuilder
{
	private SqlSession session = null;
	private SqlSessionFactory factory;
	private String resource = null;
	private Reader reader = null;	
	
	//private WyzSqlSession wyz_session = null;
	
	/**	이 생성자는 기본생성자로, MyBatis의 XML설정파일의 위치정보가
	 * 	담긴 String 타입의 데이터를 Setting 하는 작업을 한다.*/
	public SQLSessionBuilder() 
	{
        this.resource = "/common/SqlMapConfig.xml"; //default Resource Setting
	}//기본생성자()======================================================
	
	/** 이 인자생성자는 MyBatis의 XML설정파일의 위치정보가 담긴 String 타입의
	 * 	데이터를 인자로 받아서 해당 XML 파일의 설정이 적용된  SqlSession 객체를
	 * 	얻어올 수 있도록 구현한 생성자이다.*/
	public SQLSessionBuilder(String resource_path)
	{
		if(resource_path == null || resource_path.trim().equals(""))
			throw new IllegalArgumentException("Strign resource_path is null. Invalid parameter.");
		
		this.resource = resource_path;
	}//인자생성자()======================================================
	
	/**	이 메소드는 현재 Common 추상클래스에 설정된 Ibatis2(MyBatis)의 XML
	 *  설정파일에 대한 정보를 가져오는 메소드이다.
	 * */
	public String getResource() 
	{
		return resource;
	}//getResource()====================================================

	/**	이 메소드는  XML 설정파일의 정보를 설정하는 메소드이다. 
	 * 	해당 XML 설정파일의 위치(경로)와 파일 및 확장자명을  입력하면된다.
	 * */
	public void setResource(String resource) 
	{
		this.resource = resource;
	}//setResource()===================================================

	/**	이 메소드는 DB Connection을 얻기위한 MyBatis의 SqlSession을 얻어올 수
	 *  있도록 구현된 메소드이다. 이 메소드를 통해서 SqlSession을 얻어오기 이전에
	 *  getResource() 메소드를 통해서 현재 설정된 MyBatis의 XML 설정파일이
	 *  제대로 설정되어있는지 확인해야 한다.
	 * */
	public SqlSession getSQLSession() throws Exception
	{
		//this.close();
		
		this.reader = Resources.getResourceAsReader(resource);
		factory = new SqlSessionFactoryBuilder().build(reader);
		
		session = factory.openSession();
		
		//wyz_session = new WyzSqlSession(session);
		
		return session;
	}//getSession()=====================================================
	
	/**	이 메소드는 Common 추상 클래스가 가비지컬렉터에 의해 소멸될 때 현재 Common
	 *  추상클래스에서 가지고 있는 Connection이나 스트림 자원등을 반납할 수 있도록
	 *  구현된 메소드이다.
	 * */
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("finalize() 메소드에 의해 세션 자동반환");
		this.close();
	}//finalize()=======================================================
	
	/**	이 메소드는 현재 Common 추상 클래스가 가지고 있는 Connection 이나
	 *  스트림 자원을 반납할 수 있도록 구현된 메소드이다.
	 * */
	public void close() throws IOException
	{
		System.out.println("close() 메소드에 의해 session close처리함.");
				
		if(this.session != null)
		{
			this.session.close();
			this.session = null;
		}//if()-------------------------------------------------------
		
		if(this.reader != null)
		{
			this.reader.close();
			this.reader = null;
		}//if()-------------------------------------------------------
	}//close()============================================================

    public void close(SqlSession sqlSession) throws IOException
    {
        System.out.println("close(sqlSession) 메소드에 의해 session close처리함.");
        if(sqlSession != null)
        {
            sqlSession.close();
            sqlSession = null;
        }//if()-------------------------------------------------------

        if(this.session != null)
        {
            this.session.close();
            this.session = null;
        }//if()-------------------------------------------------------

        if(this.reader != null)
        {
            this.reader.close();
            this.reader = null;
        }//if()-------------------------------------------------------
    }//close()============================================================

}///////////////////////////////////////////////////////////////////////////////////////////
