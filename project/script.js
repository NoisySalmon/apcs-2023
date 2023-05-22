// Function to check if scrolling has reached the bottom
function isScrollAtBottom() {
  var content = document.getElementById("scrollable-content");
  return content.scrollTop + content.clientHeight >= content.scrollHeight;
}

// Function to load more items
function loadMoreItems() {
  var itemList = document.getElementById("item-list");

  // Simulating an asynchronous API call or data fetch
  setTimeout(function () {
    // Create new items
    var newItems = document.createDocumentFragment();
    for (var i = 0; i < 10; i++) {
      var item = document.createElement("li");
      item.textContent = "Item " + (itemList.children.length + i + 1);
      newItems.appendChild(item);
    }

    // Append new items to the list
    itemList.appendChild(newItems);
  }, 2000);
}

// Event listener for scroll events
document
  .getElementById("scrollable-content")
  .addEventListener("scroll", function () {
    if (isScrollAtBottom()) {
      loadMoreItems();
    }
  });

/// Function to handle editing a hashtag
function editHashtag(button) {
  var hashtagItem = button.closest(".hashtag");
  var hashtagName = hashtagItem.querySelector(".hashtag-name");
  var hashtagDescription = hashtagItem.querySelector(".hashtag-description");
  var hashtagCategory = hashtagItem.querySelector(".hashtag-category");
  var hashtagActions = hashtagItem.querySelector(".hashtag-actions");

  // Store the original values
  var originalName = hashtagName.textContent;
  var originalDescription = hashtagDescription.textContent;

  // Create input fields
  var nameInput = document.createElement("input");
  nameInput.type = "text";
  nameInput.value = originalName;

  var descriptionInput = document.createElement("input");
  descriptionInput.type = "text";
  descriptionInput.value = originalDescription;

  var categorySelect = document.createElement("select");
  categorySelect.innerHTML = `
      <option value="Job" ${
        hashtagCategory.textContent.includes("Job") ? "selected" : ""
      }>Job</option>
      <option value="Referral" ${
        hashtagCategory.textContent.includes("Referral") ? "selected" : ""
      }>Referral</option>
      <!-- Add more categories here -->
    `;

  // Create save button
  var saveButton = document.createElement("button");
  saveButton.textContent = "Save";
  saveButton.onclick = function () {
    saveHashtag(
      hashtagItem,
      nameInput.value,
      descriptionInput.value,
      categorySelect.value
    );
  };

  // Create cancel button
  var cancelButton = document.createElement("button");
  cancelButton.textContent = "Cancel";
  cancelButton.onclick = function () {
    cancelEditHashtag(
      hashtagItem,
      originalName,
      originalDescription,
      hashtagCategory.textContent
    );
  };

  // Replace text content with input fields and buttons
  hashtagName.textContent = "";
  hashtagName.appendChild(nameInput);

  hashtagDescription.textContent = "";
  hashtagDescription.appendChild(descriptionInput);

  hashtagCategory.textContent = "";
  hashtagCategory.appendChild(categorySelect);

  hashtagActions.innerHTML = "";
  hashtagActions.appendChild(saveButton);
  hashtagActions.appendChild(cancelButton);
}

// Function to save the edited hashtag
function saveHashtag(hashtagItem, newName, newDescription, newCategory) {
  var hashtagName = hashtagItem.querySelector(".hashtag-name");
  var hashtagDescription = hashtagItem.querySelector(".hashtag-description");
  var hashtagCategory = hashtagItem.querySelector(".hashtag-category");
  var hashtagActions = hashtagItem.querySelector(".hashtag-actions");

  // Update the hashtag details
  hashtagName.textContent = newName;
  hashtagDescription.textContent = newDescription;
  hashtagCategory.textContent = "Category: " + newCategory;

  // Restore the button functionality
  var editButton = document.createElement("button");
  editButton.textContent = "Edit";
  editButton.onclick = function () {
    editHashtag(editButton);
  };

  // Restore the delete button
  var deleteButton = document.createElement("button");
  deleteButton.textContent = "Delete";
  deleteButton.onclick = function () {
    deleteHashtag(deleteButton);
  };

  hashtagActions.innerHTML = "";
  hashtagActions.appendChild(editButton);
  hashtagActions.appendChild(deleteButton);
}

// Function to cancel the edit of a hashtag
function cancelEditHashtag(
  hashtagItem,
  originalName,
  originalDescription,
  originalCategory
) {
  var hashtagName = hashtagItem.querySelector(".hashtag-name");
  var hashtagDescription = hashtagItem.querySelector(".hashtag-description");
  var hashtagCategory = hashtagItem.querySelector(".hashtag-category");
  var hashtagActions = hashtagItem.querySelector(".hashtag-actions");

  // Restore the original values
  hashtagName.textContent = originalName;
  hashtagDescription.textContent = originalDescription;
  hashtagCategory.textContent = originalCategory;

  // Restore the button functionality
  var editButton = document.createElement("button");
  editButton.textContent = "Edit";
  editButton.onclick = function () {
    editHashtag(editButton);
  };

  // Restore the delete button
  var deleteButton = document.createElement("button");
  deleteButton.textContent = "Delete";
  deleteButton.onclick = function () {
    deleteHashtag(deleteButton);
  };

  hashtagActions.innerHTML = "";
  hashtagActions.appendChild(editButton);
  hashtagActions.appendChild(deleteButton);
}

sections = ["demographics", "services", "supplies", "referrals", "other"];
