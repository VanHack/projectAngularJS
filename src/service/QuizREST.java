package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Quiz;
import persistence.QuizDAO;

@Path("/quiz")
public class QuizREST {

//	private QuizDAO quizDAO = new QuizDAO();
	
	//http://localhost:8081/projetoAngularJS/api/quiz/list
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String listQuiz(){
		List<Quiz> lista = new ArrayList<Quiz>();
		try{
			lista = new QuizDAO().findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new Gson().toJson(lista);
	}
	
	@GET
	@Path("/showPanelQuiz")
	@Produces(MediaType.APPLICATION_JSON)
	public String showPanelQuiz(){
		Quiz quiz = new Quiz();
		try{
			quiz = new QuizDAO().findPanelQuiz();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new Gson().toJson(quiz);
	}

//	@GET
//	@Path("/merge/{description}/{optionA}/{optionB}/{optionC}/{correctOption}/")
//	@Produces("text/plain")
//	public void mergeQuiz(@PathParam("description") String description,
//						  @PathParam("optionA") String optionA, 
//						  @PathParam("optionB") String optionB,
//						  @PathParam("optionC") String optionC, 
//				          @PathParam("correctOption") String correctOption){
	@POST
	@Path("/merge")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public void mergeQuiz(String quiz){
		try{
			Gson gson = new Gson();
	        Quiz q = gson.fromJson(quiz, Quiz.class);
			
//			Quiz quiz = new Quiz();
//				  quiz.setDescription(description);
//				  quiz.setOptionA(optionA);
//				  quiz.setOptionB(optionB);
//				  quiz.setOptionC(optionC);
//				  quiz.setCorrectOption(correctOption);
			new QuizDAO().merge(q);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@GET
	@Path("/show/{id}")
	@Produces("text/plain")
	public void show(@PathParam("id") Integer id){
		try{
			new QuizDAO().show(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
