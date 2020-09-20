package sugaryo.t4jboot.app.module;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sugaryo.t4jboot.app.api.TwitterApiCall;
import sugaryo.t4jboot.app.config.ConfigSet;
import twitter4j.Status;

@Component
public class TagTweet {
	
	private static final Logger log = LoggerFactory.getLogger( TagTweet.class );


	private final TwitterApiCall twitter;
	private final ConfigSet config;
	
	public TagTweet( 
			@Autowired TwitterApiCall twitter,
			@Autowired ConfigSet config ) {
		this.twitter = twitter;
		this.config = config;
	}
	
	public Status post( String tags, String content ) {
		return this.post( split(tags), content );
	} 
	public Status post( String[] tags, String content ) {
		
		// 文字列編集してTwitterにポストするツイート本文を生成。
		var sb = new StringBuilder();
		
		final String ln = "\n";
		for ( String tag : tags ) {
			sb.append( tag );
			sb.append( ln );
		}
		sb.append( ln );
		sb.append( content );
		
		final String message = sb.toString();
		
		
		// TweetしてStatusを返す。
		return this.twitter.tweet( message );
	}
	
	private static String[] split( String tags ) {
		return Stream.of( tags.split( ",| " ) )
				.map( x -> x.trim() )
				.filter( x -> x.length() > 0 )
				.map( x -> x.startsWith( "#" ) ? x : "#" + x )
				.toArray( String[]::new );
	}
}
