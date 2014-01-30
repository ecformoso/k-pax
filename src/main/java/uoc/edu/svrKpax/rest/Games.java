package uoc.edu.svrKpax.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uoc.edu.svrKpax.bussines.AdminViewBO;
import uoc.edu.svrKpax.bussines.CategoryBO;
import uoc.edu.svrKpax.bussines.CommentBO;
import uoc.edu.svrKpax.bussines.DeveloperBO;
import uoc.edu.svrKpax.bussines.GameBO;
import uoc.edu.svrKpax.bussines.GameInstanceBO;
import uoc.edu.svrKpax.bussines.GameLikeBO;
import uoc.edu.svrKpax.bussines.GameScoreBO;
import uoc.edu.svrKpax.bussines.TagBO;
import uoc.edu.svrKpax.bussines.UserViewBO;
import uoc.edu.svrKpax.util.AES;
import uoc.edu.svrKpax.vo.AdminView;
import uoc.edu.svrKpax.vo.Category;
import uoc.edu.svrKpax.vo.Comment;
import uoc.edu.svrKpax.vo.Game;
import uoc.edu.svrKpax.vo.GameLike;
import uoc.edu.svrKpax.vo.Score;
import uoc.edu.svrKpax.vo.Tag;
import uoc.edu.svrKpax.vo.UserView;

import com.sun.jersey.spi.inject.Inject;

@SuppressWarnings("deprecation")
@Path("/game")
public class Games {

	@Inject
	private GameBO gBo;
	@Inject
	private GameLikeBO lBo;
	@Inject
	private GameInstanceBO iBo;
	@Inject
	private GameScoreBO scBo;
	@Inject
	private CategoryBO catBo;
	@Inject
	private TagBO tagBo;
	@Inject
	private CommentBO comBo;
	@Inject
	private DeveloperBO devBo;
	@Inject
	private AdminViewBO advBo;
	@Inject
	private UserViewBO usvBo;
	
	

	/* GAMES */
	/*@GET
	@Path("/{param}/list")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Game> getGames(@PathParam("param") String campusSession) {
		return gBo.listGames(campusSession);
	}
	
	
	@POST
	@Path("/add")
	public String addGame(@FormParam("secretSession") String campusSession,@FormParam("name") String nameGame,@FormParam("idGame") String idGame){
		if(gBo.addGame(campusSession, nameGame,Integer.parseInt(idGame))){
			return "OK";
		}else{
			return "ERROR";
		}
	}*/
	
	@POST
	@Path("/{param}/list/{idOrderer}/{idFilterer}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Game> getGames(@PathParam("param") String campusSession, @PathParam("idOrderer") int idOrderer, @PathParam("idFilterer") int idFilterer, @FormParam("fields") List<String> fields, @FormParam("values")  List<String> values) {
		return gBo.listGames(campusSession, idOrderer, idFilterer, fields, values);
	}
	
	@POST
	@Path("/game/{session}/listDev/{username}") 
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	//
	// No sobra el primer /game?????????????????????
	//
	public List<Game> getUserGames(@PathParam("username") String username,@PathParam("session") String campusSession) {
		return gBo.listUserGames(username, campusSession);
	}

	@POST
	@Path("/add")
	public String addGame(@FormParam("secretSession") String campusSession,@FormParam("name") String nameGame,@FormParam("idGame") String idGame, @FormParam("idCategory") String idCategory, @FormParam("creationDate") String creationDate ){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		sdf.setLenient(false);
		try
		{
			if(gBo.addGame(campusSession, nameGame,Integer.parseInt(idGame), Integer.parseInt(idCategory), sdf.parse(creationDate))){
				return "OK";
			}
		}
		catch (NumberFormatException e) {}
		catch (ParseException e) {}
		return "ERROR";
	}
	
	@POST
	//@Path("/game/{SecretSession}/add/{param}")
	@Path("/{param}/add")
	public String modifyGame(@FormParam("secretSession") String campusSession,@FormParam("name") String name,@FormParam("idGame") int idGame, @FormParam("idCategory") int idCategory, @FormParam("publicAcces") int publicAcces ){
		
		try
		{
			if(gBo.modifyGame(campusSession, name, idGame, idCategory, publicAcces)){
				return "OK";
			}
		}
		catch (RuntimeException e) {
			System.out.println(campusSession);
			System.out.println(idGame);
			e.printStackTrace();
		return "ERROR";
		}
		return "OK";
	}
	
	@GET
	@Path("/{param}/get/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public Game getGame(@PathParam("id") String idGame,@PathParam("param") String secretSession){
		return gBo.getGame(idGame,secretSession);
	}
	
	/*
	@POST
	@Path("/delete/{id}")
	public String delGame(@FormParam("secretSession") String campusSession,@PathParam("id") String idGame){
		if(gBo.delGame(campusSession, Integer.parseInt(idGame)))return "OK";
		else
			return "ERROR";
	}
	*/
	
	@POST
	@Path("/{secretSession}/delete/{id}")
	public String delGame(@FormParam("secretSession") String campusSession,@PathParam("id") String idGame){
		if(gBo.delGame(campusSession, Integer.parseInt(idGame)))return "OK";
		else
			return "ERROR";
	}
	
	/* categories */
	@GET
	@Path("/category/{param}/list")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Category> getCategories (@PathParam("param") String campusSession){
		return catBo.listCategories(campusSession);
	}
	
	@GET
	@Path("/category/{param}/get/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public Category getCategory (@PathParam("param") String campusSession, @PathParam("id") int idCategory){
		return catBo.getCategory(campusSession, idCategory);
	}
	
	/* tags */
	@GET
	@Path("/tag/{param}/list/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Tag> getTagsGame (@PathParam("param") String campusSession, @PathParam("id") int idGame){
		return tagBo.listTagsGame(campusSession, idGame);
	}
	
	@POST
	@Path("/tag/{id}/addDel")
	public String addDelTagsGame(@FormParam("secretSession") String campusSession,@PathParam("id") int idGame,@FormParam("tags") String tagsCommaSeparated){
		String [] tagsSplit = tagsCommaSeparated.split(",");
		List<Tag> tags = new ArrayList<Tag>();
		for(String tagValue : tagsSplit)
		{
			tagValue = tagValue.trim();
			if(tagValue.equals(""))
				continue;
			Tag tag = new Tag();
			tag.setTag(tagValue);
			tags.add(tag);
		}
		if(tagBo.addTagsGame(campusSession, idGame, tags))
			return "OK";
		else
			return "ERROR";
	}
	
	/* comments */
	@GET
	@Path("/comment/{param}/list/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Comment> getCommentsGame (@PathParam("param") String campusSession, @PathParam("id") int idGame){
		return comBo.listCommentsGame(campusSession, idGame);
	}
	
	@POST
	@Path("/comment/{id}/add")
	public String addCommentGame(@FormParam("secretSession") String campusSession,@PathParam("id") int idComment, @FormParam("idGame") int idGame){
		if(comBo.addComment(campusSession, idComment, idGame))
			return "OK";
		else
			return "ERROR";
	}
	
	@POST
	@Path("/comment/{id}/del")
	public String delCommentGame(@FormParam("secretSession") String campusSession,@PathParam("id") int idComment){
		if(comBo.delComment(campusSession, idComment))
			return "OK";
		else
			return "ERROR";
	}

	/* likes */
	@GET
	@Path("/like/{param}/get/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public GameLike getLikeGame (@PathParam("param") String campusSession,@PathParam("id") int idGame){
		return lBo.getLikeGame(campusSession, idGame);
	}
	
	@POST
	@Path("/like/{id}/add")
	public String likeAddGame(@FormParam("secretSession") String campusSession,@PathParam("id") String idGame,@FormParam("containerId") String containerId){
		if(lBo.addLikeGame(campusSession, Integer.parseInt(idGame),containerId))return "OK";
		else
			return "ERROR";
	}
	
	@POST
	@Path("/like/{id}/del")
	public String likeDelGame(@FormParam("secretSession") String campusSession,@PathParam("id") String idGame,@FormParam("containerId") String containerId){
		if(lBo.delLikeGame(campusSession, Integer.parseInt(idGame)))return "OK";
		else
			return "ERROR";
	}
	@POST
	@Path("/like/{id}")
	public String likeGame(@FormParam("secretSession") String campusSession,@PathParam("id") String idGame,@FormParam("containerId") String containerId){
		if(lBo.addDelLikeGame(campusSession, Integer.parseInt(idGame),containerId))return "OK";
		else
			return "ERROR";
	}

	@GET
	@Path("/like/{param}/list/{id}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<GameLike> getLikesGame(@PathParam("param") String campusSession,@PathParam("id") int idGame){	
		return lBo.listLikeGames(campusSession,idGame);
	}
	
	/* GAME INSTANCES */
	
	@POST
	@Path("/instance/init")
	public Response initGame(@FormParam("secretSession") String campusSession,@FormParam("secretGame") String uidGame){
		return iBo.initGameInstance(campusSession, uidGame);
	}
	
	@POST
	@Path("/instance/end/score")
	public Response endGameScore(@FormParam("secretSession") String campusSession,@FormParam("secretGame") String uidGame,@FormParam("points") String points) throws Exception{
		if(iBo.entGameInstance(campusSession, uidGame).getStatus() == 200){
			return scBo.addScoreGame(campusSession, uidGame,AES.descrypt(points));
		}else
			return Response.status(404).entity("Error end instance").build();
	}
	
	/* GAME SCORE */
	
	@GET
	@Path("/score/{param}/list")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Score> getScoresGame(@PathParam("param") String uidGame){	
		return scBo.listScoreGames(uidGame);
	}
	
	/*   DEVELOPER */
	@POST
	@Path("/developer/{param}/add")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public String addOwner(@FormParam("secretSession") String campusSession,@FormParam("idgame") int idgame, @FormParam("idplatform") int idplatform, @FormParam("idowner") int idowner,@FormParam("idstate") int idstate) throws ParseException{
		try
		{
			if(devBo.setDeveloper(campusSession, idgame, idplatform, idowner, idstate)){
				return "OK";
			}
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "ERROR";
			
	}
	

	@POST
	@Path("/developer/{idGame}/del")
	public String delDevelop(@FormParam("secretSession") String campusSession,@PathParam("idGame") int idGame){
		if(devBo.delGameDeveloped(campusSession, idGame))
			return "OK";
		else
			return "ERROR";
	}
	
	/*	METODOS PENDIENTES DE RENOMBRAR O BORRAR. 
	@GET
	@Path("/adminview/{param}/list/{idowner}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<AdminView> ListOwnGames (@PathParam("param") String campusSession,@PathParam("idowner") int idowner){
		return advBo.ListOwnGames(campusSession, idowner);
	}
	
	@GET
	@Path("/adminview/{param}/get/{name}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public AdminView getOneGame (@PathParam("param") String campusSession,@PathParam("name") String name){
		return advBo.getOneGame(campusSession, name);
	}
	
	@GET
	@Path("/adminview/{param}/list")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<AdminView> ListAllGames (@PathParam("param") String campusSession){
		System.out.println(campusSession);
		
		List<AdminView> returnVal=advBo.ListAllGames(campusSession);
		System.out.println(returnVal);
		return returnVal;
	}
	*/
	
	@GET
	@Path("/userview/{param}/list/{idowner}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<UserView> ListOwnGames (@PathParam("param") String campusSession,@PathParam("idowner") int idowner){
		return usvBo.ListOwnGames(campusSession, idowner);
	}
	
	@GET
	@Path("/userview/{param}/list")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<UserView> ListAllGames (@PathParam("param") String campusSession){
		System.out.println(campusSession);
		
		List<UserView> returnVal=usvBo.ListAllGames(campusSession);
		System.out.println(returnVal);
		return returnVal;
	}
	
	@GET
	@Path("/adminview/{param}/get/{idgame}")
	@Produces( { MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public AdminView getOneGame (@PathParam("param") String campusSession,@PathParam("idgame") int idgame){
		return advBo.getOneGame(campusSession, idgame);
	}
	
	public void setgBo(GameBO gBo) {
		this.gBo = gBo;
	}

	public GameBO getgBo() {
		return gBo;
	}

	public void setlBo(GameLikeBO lBo) {
		this.lBo = lBo;
	}

	public GameLikeBO getlBo() {
		return lBo;
	}

	public void setiBo(GameInstanceBO iBo) {
		this.iBo = iBo;
	}

	public GameInstanceBO getiBo() {
		return iBo;
	}

	public void setScBo(GameScoreBO scBo) {
		this.scBo = scBo;
	}

	public GameScoreBO getScBo() {
		return scBo;
	}


	public CategoryBO getCatBo() {
		return catBo;
	}


	public void setCatBo(CategoryBO catBo) {
		this.catBo = catBo;
	}


	public TagBO getTagBo() {
		return tagBo;
	}


	public void setTagBo(TagBO tagBo) {
		this.tagBo = tagBo;
	}


	public CommentBO getComBo() {
		return comBo;
	}

	public void setComBo(CommentBO comBo) {
		this.comBo = comBo;
	}
	
	
	public void setdevBo(DeveloperBO devBo) {
		this.devBo = devBo;
	}
	
	public void getadvBo(AdminViewBO advBo) {
		this.advBo = advBo;
	}
	public void getusvBo(UserViewBO usvBo) {
		this.usvBo = usvBo;
	}
}
