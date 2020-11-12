package ru.samsung.itschool.book.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;


import task.Stub;
import task.Task;

public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private int WIDTH = 9;
    private int HEIGHT = 14;

    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();

    }

    void generate() {


        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                if (Math.random() >= 0.5) {
                    cells[i][j].setBackgroundColor(Color.BLACK);
                }
            }




    @Override
    public boolean onLongClick(View v) {
        //Эту строку нужно удалить
        Stub.show(this, "Добавьте код в функцию активности onLongClick() - реакцию на долгое нажатие на клетку");
        return false;
    }

    @Override
    public void onClick(View v) {

        Button tappedCell = (Button) v;

        //Получаем координтаты нажатой клетки
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        //ADD YOUR CODE HERE
        //....

        for (int y = 0; y < HEIGHT; y++)
        {
            int color = ((ColorDrawable) cells[y][tappedX].getBackground()).getColor();
            if (color == Color.BLACK) {
                cells[y][tappedX].setBackgroundColor(Color.WHITE);
            }
            else {
                cells[y][tappedX].setBackgroundColor(Color.BLACK);
            }
        }

        for (int x = 0; x < WIDTH; x++)
        {
            int color = ((ColorDrawable) cells[tappedY][x].getBackground()).getColor();
            if (color == Color.BLACK) {
                cells[tappedY][x].setBackgroundColor(Color.WHITE);
            }
            else {
                cells[tappedY][x].setBackgroundColor(Color.BLACK);
            }

        }
        int color1 = ((ColorDrawable) cells[tappedY][tappedX].getBackground()).getColor();
        if (color1 == Color.BLACK) {
            cells[tappedY][tappedX].setBackgroundColor(Color.WHITE);
        }
        else{
            cells[tappedY][tappedX].setBackgroundColor(Color.BLACK);
        }
        }



	/*
     * NOT FOR THE BEGINNERS
	 * ==================================================
	 */

    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}