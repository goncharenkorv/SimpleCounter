package gruv.apps.simplecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Простейший счетчик, состоящий из одной активити,
 * с полем TextView и двумя кнопками Увеличения/Уменьшения
 *
 * Не содержит фрагментов
 * Без звуков
 * Без вибрации
 * Без сохранения/восстановления значения
 *
 * @author Goncharenko Ruslan
 */
public class MainActivity extends AppCompatActivity {

    // максимальное значение счетчика:
    public static final int MAX_VALUE = 9999;
    // минимальное значение счетчика:
    public static final int MIN_VALUE = -9999;
    // значение счетчика по-умолчанию:
    public static final int DEFAULT_VALUE = 0;

    // значение счетчика:
    private int value = DEFAULT_VALUE;

    // текстовое поле со счетчиком:
    private TextView counterLabel;
    // кнопка увеличения:
    private Button incrementButton;
    // кнопка уменьшения:
    private Button decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // счетчик (число):
        counterLabel = (TextView) findViewById(R.id.counterLabel);
        // устанавливаем слушателя нажатия:
        counterLabel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                increment();
            }
        });

        // кнопка увеличения:
        incrementButton = (Button) findViewById(R.id.incrementButton);
        // устанавливаем слушателя нажатия:
        incrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                increment();
            }
        });

        // кнопка уменьшения:
        decrementButton = (Button) findViewById(R.id.decrementButton);
        // устанавливаем слушателя нажатия:
        decrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                decrement();
            }
        });

        // устанавлиываем значение счетчика:
        setValue(value);
    }

    /**
     * увеличивем значение переменной value на единицу,
     * если это возможно
     */
    private void increment() {
        if (value < MAX_VALUE) {
            setValue(++value);
        }
    }

    /**
     * уменьшаем значение переменной value на единицу,
     * если это возможно
     */
    private void decrement() {
        if (value > MIN_VALUE) {
            setValue(--value);
        }
    }

    /**
     * Проверяем корректность параметра. При необходимости - корректируем.
     * Устанавливаем значение в переменную this.value и в поле counterLabel
     * Устанавливаем доступность/недоступность кнопок Увеличения/Уменьшения
     */
    private void setValue(int value) {
        if (value > MAX_VALUE) {
            value = MAX_VALUE;
        } else if (value < MIN_VALUE) {
            value = MIN_VALUE;
        }
        this.value = value;
        counterLabel.setText(Integer.toString(value));
        checkStateOfButtons();
    }

    /**
     * Устанавливаем доступность/недоступность кнопок Увеличения/Уменьшения
     */
    private void checkStateOfButtons() {
        incrementButton.setEnabled(value < MAX_VALUE);
        decrementButton.setEnabled(value > MIN_VALUE);
    }
}
