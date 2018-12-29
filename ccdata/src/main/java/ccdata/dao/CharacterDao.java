package ccdata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ccdata.models.Character;
import ccdata.utills.JDBCUtills;

public class CharacterDao {
	//修改角色信息
	public static void updateCharacter() {
		
		
		
		
	}
	//删除角色信息
	public static void delCharacter() {
		
		
		
	}
	//查询角色信息
	public static void queryCharacter() {
	}
	//增加角色信息
	public static void addCharacter(Character c) throws SQLException{
		String sql = "INSERT INTO ccdata.character (name, photourl, " + 
				"profilephotourl, affilition, rate, weapon, introduction, cost, " +
				"painter, voiceactor, criticalstrike, attackspeed, growth, acess, " + 
				"showdate, uniqueskill, uniqueskilldscription, manacost, teachingskill, " + 
				"teachingskilldscription, ability1, ability1decription, ability2, ability2decription, " +
				"feter, feterdescription, partyability) VALUES （?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?）";
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
		pstmt.setDate(15, new Date(c.getShowdate().getTime()));
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
		pstmt.execute();
		pstmt.close();
	}	
	
}
