import tkinter as tk
from tkinter import ttk
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg

# Create the main window
root = tk.Tk()
root.title("Expense Tracker")

# Create labels and entry fields
# ... (same as in the previous example)

# Create a listbox to display expenses
expense_list = tk.Listbox(root)
expense_list.pack()

# Create a figure for the graph
fig, ax = plt.subplots(figsize=(6, 4))

# Create a canvas to display the graph in the GUI
canvas = FigureCanvasTkAgg(fig, master=root)
canvas_widget = canvas.get_tk_widget()
canvas_widget.pack()

# Create a button to generate graphs
def generate_graph():
    cursor.execute("SELECT date, amount FROM expenses")
    data = cursor.fetchall()

    dates = [item[0] for item in data]
    amounts = [item[1] for item in data]

    ax.clear()
    ax.bar(dates, amounts)
    ax.set_xlabel('Date')
    ax.set_ylabel('Amount')
    ax.set_title('Expense Graph')
    canvas.draw()

generate_button = tk.Button(root, text="Generate Graph", command=generate_graph)
generate_button.pack()

# ... (same as in the previous example)

root.mainloop()
