package com.example.myapplication.tabbedactivity.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;
import com.example.myapplication.dataclasses.DoneTask;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.DoneTasksRepository;
import com.example.myapplication.repositories.TasksRepository;
import com.example.myapplication.repositories.UsersRepository;

public class DialogDoneTaskFragment extends DialogFragment {

    private static int index;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.titledialog);  // заголовок
        builder.setMessage(R.string.check); // сообщение
        builder.setPositiveButton(R.string.answeryes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), R.string.check1, Toast.LENGTH_LONG).show();

                DoneTask done = DoneTasksRepository.repository.get(index);
                User user = UsersRepository.findByNickname(done.getUserName());
                user.setScores(user.getScores() + done.getPrice());

                DoneTasksRepository.repository.remove(index);
            }
        });
        builder.setNegativeButton(R.string.answerno, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TasksRepository.add(DoneTasksRepository.repository.get(index).uncorrectDone());

                DoneTasksRepository.repository.remove(index);
            }
        });
        builder.setCancelable(true);

        return builder.create();
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        super.show(manager, tag);
        index = Integer.valueOf(tag);
    }
}
