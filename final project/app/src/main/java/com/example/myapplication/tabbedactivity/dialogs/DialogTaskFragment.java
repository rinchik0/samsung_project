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

import com.example.myapplication.EnterActivity;
import com.example.myapplication.R;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.TasksRepository;
import com.example.myapplication.repositories.UsersRepository;

public class DialogTaskFragment extends DialogFragment {

    private static int index;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        User user = UsersRepository.findByNickname(EnterActivity.enterist);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.titledialog);  // заголовок
        builder.setMessage(R.string.reservq); // сообщение
        builder.setPositiveButton(R.string.answeryes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), R.string.success, Toast.LENGTH_LONG).show();
                TasksRepository.repository.get(index).setReservation(user.getNickname());
            }
        });
        builder.setNegativeButton(R.string.answerno, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
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
