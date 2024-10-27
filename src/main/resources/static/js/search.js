
  let currentGender = 'all'; // Default to all
  let currentType = 'all'; // Default to all
  function navigate(gender,type) {
      currentGender = gender; // Set the current gender
      currentType = type;
      location.href = `/catalog?gender=${currentGender}&type=${type}`;
  }  