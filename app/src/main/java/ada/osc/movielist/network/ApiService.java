package ada.osc.movielist.network;

import ada.osc.movielist.model.CreditsResponse;
import ada.osc.movielist.model.MovieDetailsResponse;
import ada.osc.movielist.model.MovieResponse;
import ada.osc.movielist.model.GuestSession;
import ada.osc.movielist.model.RequestToken;
import ada.osc.movielist.model.Session;
import ada.osc.movielist.model.VideosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by avukelic on 20-Jun-18.
 */
public interface ApiService {

    @GET("/3/movie/popular?")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String api_key, @Query("page") int page);

    @GET("/3/movie/top_rated?")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String api_key, @Query("page") int page);

    @GET("/3/movie/upcoming?")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String api_key, @Query("page") int page);

    @GET("/3/movie/{movie_id}?")
    Call<MovieDetailsResponse> getMovieDetails(@Path("movie_id") int movieId, @Query("api_key") String api_key);

    @GET("/3/movie/{movie_id}/videos?")
    Call<VideosResponse> getMovieTrailers(@Path("movie_id") int movieId, @Query("api_key") String api_key);

    @GET("/3/movie/{movie_id}/credits?")
    Call<CreditsResponse> getMovieCredits(@Path("movie_id") int movieId, @Query("api_key") String api_key);

    @GET("/3/search/movie?")
    Call<MovieResponse> getSearchedMovies(@Query("api_key") String api_key, @Query("query") String query, @Query("page") int page);

    @GET("/3/authentication/token/new?")
    Call<RequestToken> getToken(@Query("api_key") String api_key);

    @GET("3/authentication/session/new?")
    Call<Session> getSession(@Query("api_key") String api_key, @Query("request_token") String token);

}
