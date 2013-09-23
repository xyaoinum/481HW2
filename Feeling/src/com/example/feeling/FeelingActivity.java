package com.example.feeling;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeelingActivity extends Activity {
	
	private Button B[];
	private TextView message;
	private String tempB[];
	private String mode;
	private int bomb1;
	private int bomb2;
	private int safeN;
	private Random r;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feeling);
		
		r = new Random();
		
		bomb1 = Math.abs(r.nextInt())%9;
		bomb2 = Math.abs(r.nextInt())%9;
		while (bomb2 == bomb1) {
			bomb2 = Math.abs(r.nextInt())%9;
		}
		
		mode = "play";
		
		message = (TextView)findViewById(R.id.text0);
		message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 containing bombs.");
		B = new Button[9];
		tempB = new String[9];
		
		B[0] = (Button)findViewById(R.id.button0);
		B[1] = (Button)findViewById(R.id.button1);
		B[2] = (Button)findViewById(R.id.button2);
		B[3] = (Button)findViewById(R.id.button3);
		B[4] = (Button)findViewById(R.id.button4);
		B[5] = (Button)findViewById(R.id.button5);
		B[6] = (Button)findViewById(R.id.button6);
		B[7] = (Button)findViewById(R.id.button7);
		B[8] = (Button)findViewById(R.id.button8);
		
		for(int i=0; i<9; i++) {
			B[i].setText("");
		}
		
		B[0].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=0 && bomb2!=0) {
						if((String)B[0].getText() == "") {
							safeN++;
						}
						B[0].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[0].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[0].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		
		B[1].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=1 && bomb2!=1) {
						if((String)B[1].getText() != "^_^") {
							safeN++;
						}
						B[1].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[1].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[1].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		
		B[2].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=2 && bomb2!=2) {
						if((String)B[2].getText() != "^_^") {
							safeN++;
						}
						B[2].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[2].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[2].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		B[3].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=3 && bomb2!=3) {
						if((String)B[3].getText() != "^_^") {
							safeN++;
						}
						B[3].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[3].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[3].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		B[4].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=4 && bomb2!=4) {
						if((String)B[4].getText() != "^_^") {
							safeN++;
						}
						B[4].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[4].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[4].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		
		B[5].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=5 && bomb2!=5) {
						if((String)B[5].getText() != "^_^") {
							safeN++;
						}
						B[5].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[5].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[5].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		B[6].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=6 && bomb2!=6) {
						if((String)B[6].getText() != "^_^") {
							safeN++;
						}
						B[6].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[6].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[6].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		B[7].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=7 && bomb2!=7) {
						if((String)B[7].getText() != "^_^") {
							safeN++;
						}
						B[7].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[7].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[7].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		
		B[8].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mode == "play") {
					if(bomb1!=8 && bomb2!=8) {
						if((String)B[8].getText() != "^_^") {
							safeN++;
						}
						B[8].setText("^_^");
						if(safeN == 7) {
							mode = "finish";
							message.setText("Congratulations! You are alive! Click any button to restart the game!");
							safeN = 0;
						} else {
							message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");
						}
					} else {
						mode = "finish";
						B[8].setText(">_<");
						message.setText("You are dead! Click any button to restart the game!");
						safeN = 0;
						bomb1 = Math.abs(r.nextInt())%9;
						bomb2 = Math.abs(r.nextInt())%9;
						while (bomb2 == bomb1) {
							bomb2 = Math.abs(r.nextInt())%9;
						}
					}
				} else if(mode == "cheat") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText(tempB[j]);
					}
					message.setText("Good up to now! You are supposed to click all buttons except for the 2 bombs.");					
				} else if(mode == "finish") {
					mode = "play";
					for(int j=0; j<9; j++) {
						B[j].setText("");
					}
					message.setText("There are 2 bombs in the 3x3 grid. You are supposed to click all buttons except for the 2 bombs.");
				}
			}
		});
		B[8].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if(mode == "play") {
					mode = "cheat";
					for(int j=0; j<9; j++) {
						tempB[j] = (String)B[j].getText();
					}
					for(int j=0; j<9; j++) {
						if(bomb1 == j || bomb2 == j) {
							B[j].setText(">_<");
						} else {
							B[j].setText("^_^");
						}
					}
					message.setText("Cheat mode! Click any button to resume!");
				}
				return true;
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feeling, menu);
		return true;
	}

}
