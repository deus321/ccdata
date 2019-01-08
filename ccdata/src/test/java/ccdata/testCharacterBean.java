package ccdata;
import java.sql.SQLException;

import ccdata.dao.CharacterDao;
import ccdata.models.Character;
public class testCharacterBean {
	public static void main(String[] args) throws SQLException {
		Character c = new Character();
		c.setName("fff");
		c.setPid(5);
		CharacterDao.delCharacter(c);
	}
}
