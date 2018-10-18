package br.com.tuliofmoura.androidbasics.todo.product;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

/**
 * Criado por Tulio Moura em 11/out/2018.
 */
public class TodoProductAdapter extends RecyclerView.Adapter<TodoProductAdapter.TodoProductViewHolder> {

    private List<Product> products;

    public TodoProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public TodoProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item_product, parent, false);
        return new TodoProductViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoProductViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getProductDescription());
        holder.valueTextView.setText(String.format("R$ %.2f", product.getValue()));
    }

    @Override
    public int getItemCount() {
        return products != null ? products.size() : 0;
    }

    class TodoProductViewHolder extends RecyclerView.ViewHolder {

        TextView establishmentIdTextView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView valueTextView;
        ImageView addButtonImageView;

        TodoProductViewHolder(View view) {
            super(view);
            establishmentIdTextView = view.findViewById(R.id.establishment_id_label);
            nameTextView = view.findViewById(R.id.product_name_label);
            descriptionTextView = view.findViewById(R.id.product_description_label);
            valueTextView = view.findViewById(R.id.product_value_label);
            addButtonImageView = view.findViewById(R.id.add_btn);
        }
    }
}
