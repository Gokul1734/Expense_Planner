import matplotlib.pyplot as plt

# Initialize empty lists for expenses and dates
expenses = []
dates = []

# Function to add an expense
def add_expense(amount, date):
    expenses.append(amount)
    dates.append(date)

# Function to plot expenses
def plot_expenses():
    plt.figure(figsize=(10, 6))  # Set the figure size
    plt.plot(dates, expenses, marker='o', linestyle='-', color='b')
    plt.title("Expense Tracker")
    plt.xlabel("Date")
    plt.ylabel("Expense Amount")
    plt.xticks(rotation=45)  # Rotate x-axis labels for better readability
    plt.grid(True)
    plt.tight_layout()
    plt.show()

# Main expense tracking loop
while True:
    print("Expense Tracker")
    print("1. Add Expense")
    print("2. Plot Expenses")
    print("3. Quit")
    choice = input("Enter your choice: ")

    if choice == '1':
        amount = float(input("Enter the expense amount: "))
        date = input("Enter the date (YYYY-MM-DD): ")
        add_expense(amount, date)
        print("Expense added successfully!")

    elif choice == '2':
        if not expenses:
            print("No expenses to plot.")
        else:
            plot_expenses()

    elif choice == '3':
        break

    else:
        print("Invalid choice. Please select a valid option.")

print("Thank you for using the Expense Tracker!")
