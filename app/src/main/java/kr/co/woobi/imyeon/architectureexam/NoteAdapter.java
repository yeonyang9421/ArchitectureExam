package kr.co.woobi.imyeon.architectureexam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
        Note currentNote = notes.get(i);
        noteHolder.textViewTitle.setText(currentNote.getTitle());
        noteHolder.textDescripttion.setText(currentNote.getDescription());
        noteHolder.textPriority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public  void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle, textDescripttion, textPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_title);
            textDescripttion = itemView.findViewById(R.id.text_description);
            textPriority = itemView.findViewById(R.id.text_priority);
        }
    }
}
