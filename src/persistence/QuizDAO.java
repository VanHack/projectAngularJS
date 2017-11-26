package persistence;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entity.Quiz;

public class QuizDAO extends DAO{

	public List<Quiz> findAll() throws Exception{
		open();
		List<Quiz> list = new ArrayList<Quiz>();
		stmt = con.prepareStatement("SELECT id, descricao, opcao_a, opcao_b, opcao_c, opcao_correta, data_cadastro, "
				+ "data_validade, available FROM hockey_game.quiz ORDER BY id");
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			Quiz q = new Quiz();
			q.setId(rs.getInt("id"));
			q.setDescription(rs.getString("descricao"));
			q.setOptionA(rs.getString("opcao_a"));
			q.setOptionB(rs.getString("opcao_b"));
			q.setOptionC(rs.getString("opcao_c"));
			q.setCorrectOption(rs.getString("opcao_correta"));
			q.setCorrectOption(rs.getString("opcao_correta"));
			q.setAvailable(rs.getBoolean("available"));
			list.add(q);
		}
		close();
		return list;
	}

	public Quiz findPanelQuiz() throws Exception{
		open();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT "); 
        sb.append(" q.id AS id, ");
        sb.append(" q.descricao AS descricao, ");
        sb.append(" q.opcao_a AS opcao_a, ");
        sb.append(" q.opcao_b AS opcao_b, ");
        sb.append(" q.opcao_c AS opcao_c, ");
        sb.append(" q.opcao_correta AS opcao_correta, ");
        sb.append(" q.data_validade AS data_validade, ");
        sb.append(" q.available AS available ");
        sb.append("FROM ");
        sb.append("    quiz q ");
        sb.append("WHERE ");
        sb.append(" (ISNULL(q.removido) OR (q.removido = 0)) ");
        sb.append(" AND (CAST(q.data_validade AS DATE) = CAST(NOW() AS DATE)) "); 
        sb.append(" AND available = 1 ");
        sb.append("ORDER BY q.id LIMIT 1 ");
		
		stmt = con.prepareStatement(sb.toString());
		
		rs = stmt.executeQuery();
		
		Quiz q = null;
		if (rs.next()){
			q = new Quiz();
			q.setId(rs.getInt("id"));
			q.setDescription(rs.getString("descricao"));
			q.setOptionA(rs.getString("opcao_a"));
			q.setOptionB(rs.getString("opcao_b"));
			q.setOptionC(rs.getString("opcao_c"));
			q.setCorrectOption(rs.getString("opcao_correta"));
			q.setDataToShow(javaSQLTimestampToCalendar(rs.getTimestamp("data_validade")));
			q.setAvailable(rs.getBoolean("available"));
		}
		close();
		return q;
	}
	
	public Calendar javaSQLTimestampToCalendar(Timestamp timestamp) {
		if (timestamp == null) {
			return null;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		return calendar;
	}

	public void merge(Quiz q) throws Exception{
		open();
		if (q.getId() == null){
			stmt = con.prepareStatement("insert into quiz (descricao, opcao_a, opcao_b, opcao_c, opcao_correta, data_cadastro) values (?, ?, ?, ?, ?, now())");
		}else{
			stmt = con.prepareStatement("update quiz set descricao = ?, opcao_a = ?, opcao_b = ?, opcao_c = ?, opcao_correta = ?,  where id = ?");
			stmt.setInt(6, q.getId());
		}
		stmt.setString(1, q.getDescription());
		stmt.setString(2, q.getOptionA());
		stmt.setString(3, q.getOptionB());
		stmt.setString(4, q.getOptionC());
		stmt.setString(5, q.getCorrectOption());
		stmt.execute();
		close();
	}
	
	public void show(int id) throws Exception{
		open();
		stmt = con.prepareStatement("SELECT available FROM quiz WHERE id = ? ");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		Quiz q = null;
		if (rs.next()){
			q = new Quiz();
			q.setAvailable(rs.getBoolean("available"));
		}
		
		stmt.close();
		stmt = con.prepareStatement("UPDATE quiz SET available = ? WHERE id = ?");
		stmt.setBoolean(1, !q.getAvailable());
		stmt.setInt(2, id);
		stmt.execute();
		close();
	}
	
}
