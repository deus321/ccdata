package ccdata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ccdata.models.Character;
import ccdata.utills.JDBCUtills;

public class CharacterDao {
	//修改角色信息
	public static void updateCharacter(Character c) throws SQLException{
		String sql = "UPDATE ccdatabase.character SET name = ?, photourl = ?, " + 
				"profilephotourl = ?, affilition = ?, rate = ?, weapon = ?, introduction = ?, cost = ?, " + 
				"painter = ?, voiceactor = ?, criticalstrike = ?, attackspeed = ?, growth = ?, acess = ?, " + 
				"showdate = ?, uniqueskill = ?, uniqueskilldscription = ?, manacost = ?, teachingskill = ?," + 
				"teachingskilldescription = ?, ability1 = ?, ability1decription = ?, ability2 = ?, ability2decription = ?," + 
				"feter = ?, feterdescription = ?, partyability = ? WHERE pid = ?";
		PreparedStatement pstmt = JDBCUtills.getPreparedStatement(sql);
		pstmt.setString(1, c.getName());
		pstmt.setString(2, c.getPhotourl());
		pstmt.setString(3, c.getProfilephotourl());
		pstmt.setString(4, c.getAffilition());
		pstmt.setInt(5, c.getRate());
		pstmt.setString(6, c.getWeapon());
		pstmt.setString(7, c.getIntroduction());
		pstmt.setInt(8, c.getCost());
		pstmt.setString(9, c.getPainter());
		pstmt.setString(10, c.getVoiceactor());
		pstmt.setString(11, c.getCriticalstrike());
		pstmt.setString(12, c.getAttackspeed());
		pstmt.setString(13, c.getGrowth());
		pstmt.setString(14, c.getAcess());
		if (c.getShowdate() == null) {
			pstmt.setDate(15, null);
		}else {
			pstmt.setDate(15, new Date(c.getShowdate().getTime()));
		}
		pstmt.setString(16, c.getUniqueskill());
		pstmt.setString(17, c.getUniqueskilldscription());
		pstmt.setInt(18, c.getManacost());
		pstmt.setString(19, c.getTeachingskill());
		pstmt.setString(20, c.getTeachingskilldescription());
		pstmt.setString(21, c.getAbility1());
		pstmt.setString(22, c.getAbility2());
		pstmt.setString(23, c.getAbility1decription());
		pstmt.setString(24, c.getAbility2decription());
		pstmt.setString(25, c.getFeter());
		pstmt.setString(26, c.getFeterdescription());
		pstmt.setString(27, c.getPartyability());
		pstmt.setInt(28, c.getPid());
		pstmt.execute();
		pstmt.close();
	}
	//删除角色信息
	public static void delCharacter(Character c) throws SQLException{
		String sql = "DELETE FROM ccdatabase.character WHERE pid = ?";
		PreparedStatement pstmt = JDBCUtills.getPreparedStatement(sql);
		pstmt.setInt(1, c.getPid());
		pstmt.execute();
		pstmt.close();
		
	}
	//查询角色信息
	public static void queryCharacter() {
		String sql = "SELECT * FROM ccdatabase.character WHERE pid = ?";
		PreparedStatement pstmt = JDBCUtills.getPreparedStatement(sql);
	}
	//增加角色信息
	public static void addCharacter(Character c) throws SQLException{
		String sql = "INSERT INTO ccdatabase.character (name, photourl, " + 
				"profilephotourl, affilition, rate, weapon, introduction, cost, " +
				"painter, voiceactor, criticalstrike, attackspeed, growth, acess, " + 
				"showdate, uniqueskill, uniqueskilldscription, manacost, teachingskill, " + 
				"teachingskilldescription, ability1, ability1decription, ability2, ability2decription, " +
				"feter, feterdescription, partyability) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = JDBCUtills.getPreparedStatement(sql);

		pstmt.setString(1, c.getName());
		pstmt.setString(2, c.getPhotourl());
		pstmt.setString(3, c.getProfilephotourl());
		pstmt.setString(4, c.getAffilition());
		pstmt.setInt(5, c.getRate());
		pstmt.setString(6, c.getWeapon());
		pstmt.setString(7, c.getIntroduction());
//		pstmt.setInt(8, c.getCost());注意允许cost为null时，setObject方法
		pstmt.setObject(8, c.getCost());
		pstmt.setString(9, c.getPainter());
		pstmt.setString(10, c.getVoiceactor());
		pstmt.setString(11, c.getCriticalstrike());
		pstmt.setString(12, c.getAttackspeed());
		pstmt.setString(13, c.getGrowth());
		pstmt.setString(14, c.getAcess());
		if (c.getShowdate() == null) {
			pstmt.setDate(15, null);
		}else {
			pstmt.setDate(15, new Date(c.getShowdate().getTime()));
		}
		pstmt.setString(16, c.getUniqueskill());
		pstmt.setString(17, c.getUniqueskilldscription());
		pstmt.setInt(18, c.getManacost());
		pstmt.setString(19, c.getTeachingskill());
		pstmt.setString(20, c.getTeachingskilldescription());
		pstmt.setString(21, c.getAbility1());
		pstmt.setString(22, c.getAbility2());
		pstmt.setString(23, c.getAbility1decription());
		pstmt.setString(24, c.getAbility2decription());
		pstmt.setString(25, c.getFeter());
		pstmt.setString(26, c.getFeterdescription());
		pstmt.setString(27, c.getPartyability());
//		方法二利用反射Method类正则检索get方法遍历利用setObject方法来插值 不成功 原因 Methods数组内的方法无序无法一一对应
//		Class<?> ch = null;
//		try {
//			ch = Class.forName("ccdata.models.Character");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Method[] methods = ch.getMethods();
//		String regex = "get/w+/(.+/)";
//		int count = 0;
//		for (Method method : methods) {
//			Pattern p = Pattern.compile(regex);
//			Matcher mh = p.matcher(method.toString());
//			System.out.println(method);
//			while(mh.find()) {
//				System.out.println(1);
//				count++;
//				if(count < 28)
//				try {
//					pstmt.setObject(count, method.invoke(c));
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				};
//			}
//		}
		pstmt.execute();
		pstmt.close();
		
	}	
	
}



