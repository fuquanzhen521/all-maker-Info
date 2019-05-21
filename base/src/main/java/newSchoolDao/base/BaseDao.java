package newSchoolDao.base;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/*
 * 作者:付全镇
 * 类名:BaseDao
 * 作用:抽象出各DAO操作的共同部分,并作为父类
 * 日期:5/15
 */

public class BaseDao {

	// 声明JdbcTemplate类型变量并赋予初值
	private JdbcTemplate jdbcTemplate = init();
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 连接数据库
	public JdbcTemplate init() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// 加载驱动程序
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// url指向要访问的数据库名
		dataSource.setUrl("jdbc:mysql://localhost:3306/schooldatabase?useUnicode=true&characterEncoding=UTF-8");
		// MySQL配置时的用户名
		dataSource.setUsername("root");
		// MySQL配置时的密码
		dataSource.setPassword("root");
		// 给JdbcTemplate注入一个数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> namedParameterJdbcTemplateSelect(String sql, Map<String, Object> parameters) {
		// 初始化NamedParameterJdbcTemplate对象
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		// 调用namedParameterJdbcTemplate的queryForList方法,执行sql语句
		List<Map<String, Object>> users = this.namedParameterJdbcTemplate.queryForList(sql, parameters);
		// 返回集合users
		return users;
	}

	/*
	 * 插入数据,返回主键
	 */
	public long insert(final String sql, MapSqlParameterSource parameters) {
		// 初始化namedParameterJdbcTemplate对象
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		// 定义KeyHolder类型的对象keyHolder,并规定了它的实现类GeneratedKeyHolder,用来获取主键
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int autoIncId = 0;
		// 插入一条数据,并返回主键字段名
		this.namedParameterJdbcTemplate.update(sql, parameters, keyHolder, new String[] { "ID" });
		// 获得插入的主键
		autoIncId = keyHolder.getKey().intValue();
		// 返回主键
		return autoIncId;
	}

	/*
	 * 查询所有数据
	 */
	public List<Map<String, Object>> queryTest(String sql) {
		List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
		return users;
	}

	/*
	 * 插入数据,不返回任何值
	 */
	public void onlyInsert(String sql, Map<String, Object> parameters) {
		// 初始化NamedParameterJdbcTemplate对象
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		// 调用namedParameterJdbcTemplate的queryForList方法,执行sql语句
		this.namedParameterJdbcTemplate.update(sql, parameters);
	}
}
