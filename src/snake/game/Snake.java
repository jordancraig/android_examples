package snake.game;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jieehd.android.examples.R;

public class Snake extends Activity {
	

		  private SnakeView mSnakeView;

		  private static String ICICLE_KEY = "snake-view";

		  /**
		   * Called when Activity is first created. Turns off the title bar, sets up
		   * the content views, and fires up the SnakeView.
		   * 
		   */
		  @Override
		  public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);

		    setContentView(R.layout.snake_layout);

		    mSnakeView = (SnakeView) findViewById(R.id.snake);
		    mSnakeView.setTextView((TextView) findViewById(R.id.text));

		    if (savedInstanceState == null) {
		      // We were just launched -- set up a new game
		      mSnakeView.setMode(SnakeView.READY);
		    } else {
		      // We are being restored
		      Bundle map = savedInstanceState.getBundle(ICICLE_KEY);
		      if (map != null) {
		        mSnakeView.restoreState(map);
		      } else {
		        mSnakeView.setMode(SnakeView.PAUSE);
		      }
		    }
		  }

		  @Override
		  protected void onPause() {
		    super.onPause();
		    // Pause the game along with the activity
		    mSnakeView.setMode(SnakeView.PAUSE);
		  }

		  @Override
		  public void onSaveInstanceState(Bundle outState) {
		    // Store the game state
		    outState.putBundle(ICICLE_KEY, mSnakeView.saveState());
		  }


}
