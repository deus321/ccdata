package ccdata;
import java.sql.SQLException;

import ccdata.dao.CharacterDao;
import ccdata.models.Character;
public class testCharacterBean {
	public static void main(String[] args) throws SQLException {
		Character c = new Character();
		c.setName("fffff");
		CharacterDao.addCharacter(c);
	}
}
